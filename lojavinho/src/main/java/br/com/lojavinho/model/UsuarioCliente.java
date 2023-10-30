package br.com.lojavinho.model;

public class UsuarioCliente {

    private String cliente;
    private String senhaCliente;
    private String cpfCliente;
    private String emailCliente;
    private String telefoneCliente;

    public UsuarioCliente(String cliente) {
        this.cliente = cliente;
    }

    public UsuarioCliente(String senhaCliente, String cpfCliente) {
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
    }

    public UsuarioCliente(String cliente, String senhaCliente, String cpfCliente, String emailCliente, String telefoneCliente) {
        this.cliente = cliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
    }

    public String getCliente() {
        return cliente;
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
