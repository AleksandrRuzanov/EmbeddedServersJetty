package com.epam.embeddedservers.servlet;

import com.epam.embeddedservers.entity.AbstractEntity;
import com.epam.embeddedservers.factory.FactoryEntity;
import com.epam.embeddedservers.factory.FactoryService;
import com.epam.embeddedservers.service.EntityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Aleksandr_Ruzanov on 23.05.2017.
 */

public class EntityServlet<T extends AbstractEntity> extends AbstractServlet {

    private final EntityService entityService;
    private final Class clazz;

    public EntityServlet(Class clazz) {
        this.clazz = clazz;
        entityService = FactoryService.getService(clazz);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AbstractEntity entity = FactoryEntity.getEntityByRequest(clazz, request);
        entity = entityService.add(entity);
        response.setContentType("text/plain");
        response.getWriter().write(entity.toString());
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        response.setContentType("text/plain");
        if (id == null)
            response.getWriter().write("not send param id");
        else {
            entityService.delete(Long.parseLong(id));
            response.getWriter().write("entity=" + id + " is deleted");
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AbstractEntity entity = FactoryEntity.getEntityByRequest(clazz, request);
        entity = entityService.update(entity);
        response.setContentType("text/plain");
        response.getWriter().write(entity.toString());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] path = request.getPathInfo().split("/");
        String id = path[path.length - 1];
        response.setContentType("text/plain");
        if (path.length > 2 && path[2].matches("\\d+")) {
            T t = (T) entityService.getById(Long.parseLong(id));
            if (t != null)
                response.getWriter().write(t.toString());
            else
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            List<T> list = entityService.getAll();
            if (list != null && list.size() > 0)
                response.getWriter().write(entityService.getAll().toString());
            else
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }
}

