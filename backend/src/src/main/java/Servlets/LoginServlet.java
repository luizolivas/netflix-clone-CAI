package Servlets;

import DAO.UsuarioDAO;
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
import java.util.UUID;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificar o usuário e senha, e se for válido, criar a sessão
        if (validarUsuario(request, username, password)) {
            HttpSession session = request.getSession(true); // Cria uma nova sessão ou recupera a existente
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username);

            response.sendRedirect("/filme"); // Redireciona para a tela de filmes após o login
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Email ou senha incorretos, tente novamente!");
        }
    }

    private boolean validarUsuario(HttpServletRequest request, String username, String password) {

        UsuarioDAO usuarioDAO = getUsuarioDAO(request.getServletContext());

        Usuario u1 = new Usuario("Luiz", 21, "luiz@email.com","luiz123","1" );
        usuarioDAO.adicionarUsuario(u1);
        Usuario u2 = new Usuario("Fulano", 17, "fulano@email.com","fulano123", "2");
        usuarioDAO.adicionarUsuario(u2);
        Usuario u3 = new Usuario("Cicrano", 25, "cicrano@email.com","cicrano123", "3");
        usuarioDAO.adicionarUsuario(u3);

        List<Usuario> listUser = usuarioDAO.getUsuarios();

        boolean logado = false;

        for(Usuario usuario : listUser){
            if (usuario.getEmail().equals(username) && usuario.getSenha().equals(password)) {
                logado = true;
                break;
            }
        }

        return logado;
    }

    private UsuarioDAO getUsuarioDAO(ServletContext servletContext) {
        UsuarioDAO usuarioDAO = (UsuarioDAO) servletContext.getAttribute("usuarioDAO");

        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
            servletContext.setAttribute("usuarioDAO", usuarioDAO);
        }

        return usuarioDAO;
    }
}

