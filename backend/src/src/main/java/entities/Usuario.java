package entities;

public class Usuario {

    private String nome;
    private int idade;
    private String email;
    private String senha;
    private String sessionId;

    public Usuario() {
    }

    public Usuario(String nome, int idade, String email, String senha, String sessionId) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.sessionId = sessionId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


}
