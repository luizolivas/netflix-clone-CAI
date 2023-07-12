package com.netflixclone.servlets.login;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflixclone.dtos.UserDTO;
import com.netflixclone.entities.User;
import com.netflixclone.services.UserService;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
    private UserService userService = new UserService();
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        UserDTO user = new UserDTO(email, password);
        

        User userFinded = userService.findUser(user);
        
        if(userFinded == null) {
            JsonObject messageJson = Json.createObjectBuilder()
                    .add("message", "Preencha corretamente os campos!")
                    .build();
        	
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().println(messageJson.toString());
            return;
        }

        JsonObject userJson = Json.createObjectBuilder()
        		.add("message", "Login Realizado! Conectando..")
                .add("id", userFinded.getSessionId())
                .add("email", userFinded.getEmail())
                .add("password", userFinded.getPassword())
                .build();

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.setContentType("application/json");
        response.getWriter().println(userJson.toString());
        return;
    }
}
