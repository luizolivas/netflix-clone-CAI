package com.netflixclone;

import com.netflixclone.servlets.userLogId.GetUserLogadoId;
import com.netflixclone.servlets.login.LoginServlet;
import com.netflixclone.servlets.tmbdAPI.ComedyServlet;
import com.netflixclone.servlets.tmbdAPI.DocumentaryServlet;
import com.netflixclone.servlets.tmbdAPI.NetflixOriginalsServlet;
import com.netflixclone.servlets.tmbdAPI.RomanceServlet;
import com.netflixclone.servlets.tmbdAPI.TopRatedServlet;
import com.netflixclone.servlets.tmbdAPI.TrendingServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;

public class Main {
    public static void main(String[] args) throws Exception {
       Server server = new Server(8080); // HTTP Port

       ServletContextHandler context = new ServletContextHandler();
       context.setContextPath("/");
       server.setHandler(context);
   
       FilterHolder corsFilter = context.addFilter(CrossOriginFilter.class, "/*", null);
       corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,PUT,DELETE,HEAD,OPTIONS");
       corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "http://localhost:5173"); // React DNS
       corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");

       context.addServlet(new ServletHolder(new LoginServlet()), "/auth/login");
       context.addServlet(new ServletHolder(new GetUserLogadoId()), "/auth/session");
        
       context.addServlet(new ServletHolder(new TrendingServlet()), "/videos/trending");
       context.addServlet(new ServletHolder(new TopRatedServlet()), "/videos/toprated");
       context.addServlet(new ServletHolder(new NetflixOriginalsServlet()), "/videos/netflixoriginals");
       context.addServlet(new ServletHolder(new ComedyServlet()), "/videos/comedy");
       context.addServlet(new ServletHolder(new DocumentaryServlet()), "/videos/documentary");
       context.addServlet(new ServletHolder(new RomanceServlet()), "/videos/romance");

        
       server.start();
       server.join();
    }
}