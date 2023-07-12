package com.netflixclone.servlets.userLogId;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflixclone.entities.User;
import com.netflixclone.services.UserService;

import java.io.IOException;

public class GetUserLogadoId extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
    private UserService userService = new UserService();
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        User userFinded = userService.getUserByIdToken(Integer.parseInt(id));
        
        if(userFinded == null) {
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().println("Usuário inválido!");
            return;
        }

        JsonObject userJson = Json.createObjectBuilder()
                .add("id", userFinded.getSessionId())
                .add("name", userFinded.getName())
                .add("age", userFinded.getAge())
                .add("email", userFinded.getEmail())
                .add("password", userFinded.getPassword())
                .build();

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.setContentType("application/json");
        response.getWriter().println(userJson.toString());
        return;
    }
}
