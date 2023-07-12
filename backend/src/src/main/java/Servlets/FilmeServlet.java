package Servlets;

import DAO.UsuarioDAO;

import entities.Filme;
import entities.Usuario;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FilmeServlet extends HttpServlet {

}

//public class FilmeServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false); // Obtém a sessão existente, se houver
//
//        if (session != null && session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
//            String username = (String) session.getAttribute("username");
//
//            UsuarioDAO usuarioDAO = getUsuarioDAO(request.getServletContext());
//            Usuario usuario = usuarioDAO.buscarUsuarioPorEmail(username);
//
//            if (usuario != null) {
//                // Determine a tela de filmes com base na idade do usuário
//                String telaDeFilmes;
//                if (usuario.getIdade() < 18) {
//                    telaDeFilmes = "Tela kids";
//                } else {
//                    telaDeFilmes = "Tela adultos";
//                }
//
//                // Exiba a mensagem correspondente à tela de filmes
//                response.getWriter().println("Logado na " + telaDeFilmes);
//            } else {
//                // O usuário não está logado ou não foi encontrado no repositório, redireciona de volta para o login
//                response.sendRedirect("/login");
//            }
//        } else {
//            // O usuário não está logado, redireciona de volta para o login
//            response.sendRedirect("/login");
//        }
//    }
//
//    private UsuarioDAO getUsuarioDAO(ServletContext servletContext) {
//        UsuarioDAO usuarioDAO = (UsuarioDAO) servletContext.getAttribute("usuarioDAO");
//
//        if (usuarioDAO == null) {
//            usuarioDAO = new UsuarioDAO();
//            servletContext.setAttribute("usuarioDAO", usuarioDAO);
//        }
//
//        return usuarioDAO;
//    }
//}
