package Servlets;

import org.json.simple.JSONArray;
import response.FilmeResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NetflixOriginalsServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   private FilmeResponse tmdbService = new FilmeResponse();
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	  String id = request.getParameter("id");
	   
      JSONArray movies = tmdbService.netflixOriginalsMovies(Integer.parseInt(id));
      

      if(movies == null) {
         response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
         response.setContentType("application/json");
         response.getWriter().println("Não foi possível buscar por filmes em alta!");
         return;
      }
      
      response.setStatus(HttpServletResponse.SC_ACCEPTED);
      response.setContentType("application/json");
      response.getWriter().println(movies.toString());
      return;
   }

}
