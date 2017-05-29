package com.epam.embeddedservers.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aleksandr_Ruzanov on 26.05.2017.
 */
public abstract class AbstractServlet extends HttpServlet implements IServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plan");
        response.getWriter().write("not support GET");
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plan");
        response.getWriter().write("not support POST");
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plan");
        response.getWriter().write("not support DELETE");
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plan");
        response.getWriter().write("not support PUT");
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
