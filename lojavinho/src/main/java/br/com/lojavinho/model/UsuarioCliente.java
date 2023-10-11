package br.com.lojavinho.model;

public class UsuarioCliente {

    private String usuarioNomeCliente;
    private String senhaCliente;
    private String cpfCliente;

    private String emailCliente;;

    private String telefoneCliente;

    public UsuarioCliente(String usuarioNomeCliente, String senhaCliente) {
        this.usuarioNomeCliente = usuarioNomeCliente;
        this.senhaCliente = senhaCliente;
    }

    public UsuarioCliente(String usuarioNomeCliente, String senhaCliente, String cpfCliente, String emailCliente, String telefoneCliente) {
        this.usuarioNomeCliente = usuarioNomeCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
    }

    public String getUsuarioNomeCliente() {
        return usuarioNomeCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }
}
