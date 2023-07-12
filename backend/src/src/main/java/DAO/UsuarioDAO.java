package DAO;

import entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {

                return usuario;
            }
        }
        return null;
    }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
