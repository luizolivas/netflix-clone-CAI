import Servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        SessionHandler sessionHandler = new SessionHandler();
        context.setSessionHandler(sessionHandler);

        context.addServlet(new ServletHolder(new LoginServlet()), "auth/login");
        context.addServlet(new ServletHolder(new FilmeServlet()), "/filme");
        context.addServlet(new ServletHolder(new NetflixOriginalsServlet()), "/videos/netflixoriginals");
        context.addServlet(new ServletHolder(new TopRatedServlet()), "/videos/toprated");
        context.addServlet(new ServletHolder(new ComedyServlet()), "/videos/comedy");
        context.addServlet(new ServletHolder(new RomanceServlet()), "/videos/romance");
        context.addServlet(new ServletHolder(new DocumentaryServlet()), "/videos/documentary");

        server.setHandler(context);


        server.start();
        server.join();

    }
}