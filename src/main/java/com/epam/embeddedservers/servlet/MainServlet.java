package com.epam.embeddedservers.servlet;

import com.epam.embeddedservers.factory.FactoryServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aleksandr_Ruzanov on 24.05.2017.
 */
public class MainServlet extends AbstractServlet {

    private FactoryServlet factoryServlet;

    public MainServlet() {
        factoryServlet = new FactoryServlet();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        factoryServlet.getServlet(request).doGet(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        factoryServlet.getServlet(request).doPost(request, response);

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        factoryServlet.getServlet(request).doDelete(request, response);

    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        factoryServlet.getServlet(request).doPut(request, response);

    }
}
