package br.com.lojavinho.model;

public class UsuarioCliente {

    private String nomeCliente;
    private String senhaCliente;
    private String cpfCliente;
    private String emailCliente;
    private String telefoneCliente;

    public UsuarioCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public UsuarioCliente(String cpfCliente, String senhaCliente) {
        this.cpfCliente = cpfCliente;
        this.senhaCliente = senhaCliente;
    }

    public UsuarioCliente(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.senhaCliente = senhaCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
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
