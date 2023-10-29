package br.com.lojavinho.model;
///
public class UsuarioAdmin {

    private String emailAdmin;
    private String senhaAdmin;

    public UsuarioAdmin(String emailAdmin, String senhaAdmin) {
        this.emailAdmin = emailAdmin;
        this.senhaAdmin = senhaAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

}
