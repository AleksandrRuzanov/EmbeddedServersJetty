package com.epam.embeddedservers.server;

import com.epam.embeddedservers.servlet.MainServlet;
import com.epam.embeddedservers.servlet.TimeServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerJetty extends Server {

    public static final int PORT = 8888;

    public ServerJetty(boolean isOpenBrowser) throws Exception {
        super(PORT);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        setHandler(context);

        context.addServlet(new ServletHolder(new MainServlet()), "/*");
        //context.addServlet(new ServletHolder(new TimeServlet()), "/time");

        start();
        System.out.println("Server on port " + getURI());
    }

}
