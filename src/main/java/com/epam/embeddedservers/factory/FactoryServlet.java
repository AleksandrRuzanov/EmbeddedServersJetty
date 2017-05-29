package com.epam.embeddedservers.factory;

import com.epam.embeddedservers.entity.Department;
import com.epam.embeddedservers.servlet.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aleksandr_Ruzanov on 24.05.2017.
 */
public class FactoryServlet {

    private final TimeServlet timeServlet;
    private final PersonServlet personServlet;
    private final EntityServlet departmentServlet;
    private final EmptyServlet emptyServlet;

    public FactoryServlet() {
        timeServlet = new TimeServlet();
        personServlet = new PersonServlet();
        departmentServlet = new EntityServlet(Department.class);
        emptyServlet = new EmptyServlet();
    }

    public IServlet getServlet(HttpServletRequest request) {
        String[] path = request.getPathInfo().split("/");
        if (path.length > 0) {
            if ("time".equals(path[1])) {
                return timeServlet;
            } else if ("dep".equals(path[1])) {
                if (path.length > 3 && "person".equals(path[3]))
                    return personServlet;
                return departmentServlet;
            }
        }
        return emptyServlet;
    }


}
