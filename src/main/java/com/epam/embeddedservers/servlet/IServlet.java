package com.epam.embeddedservers.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aleksandr_Ruzanov on 24.05.2017.
 */
public interface IServlet {

    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
