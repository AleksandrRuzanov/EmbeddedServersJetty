package com.epam.embeddedservers.servlet;

import com.epam.embeddedservers.entity.Department;
import com.epam.embeddedservers.entity.Person;
import com.epam.embeddedservers.factory.FactoryEntity;
import com.epam.embeddedservers.factory.FactoryService;
import com.epam.embeddedservers.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Aleksandr_Ruzanov on 23.05.2017.
 */

public class PersonServlet extends AbstractServlet {

    private final PersonService personServlet;

    public PersonServlet() {
        personServlet = (PersonService) FactoryService.getService(Person.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] path = request.getPathInfo().split("/");
        response.setContentType("text/plain");
        if (path.length == 4) {
            Person person = (Person) FactoryEntity.getEntityByRequest(Person.class, request);
            person.setDepartment((Department) FactoryService.getService(Department.class).getById(Long.parseLong(path[2])));
            person = personServlet.add(person);
            response.getWriter().write(person.toString());
        } else
            response.setStatus(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] path = request.getPathInfo().split("/");
        response.setContentType("text/plain");
        if (path.length == 5) {
            personServlet.delete(Long.parseLong(path[4]));
            response.getWriter().write("entity=" + path[4] + " is deleted");
        } else
            response.setStatus(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] path = request.getPathInfo().split("/");
        response.setContentType("text/plain");
        if (path.length == 5) {
            Person entity = (Person) FactoryEntity.getEntityByRequest(Person.class, request);
            entity = personServlet.update(entity);
            response.getWriter().write(entity.toString());
        } else
            response.setStatus(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] path = request.getPathInfo().split("/");
        response.setContentType("text/plain");
        if (path.length == 5) {
            Person person = personServlet.getById(Long.parseLong(path[4]));
            if (person != null)
                response.getWriter().write(person.toString());
            else
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            List<Person> list = personServlet.getAllDep(Long.parseLong(path[2]));
            if (list != null && list.size() > 0)
                response.getWriter().write(list.toString());
            else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }
    }

}

