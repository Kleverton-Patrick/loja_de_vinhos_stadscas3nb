package br.com.lojavinho.model;

public class Vinho {
    public Vinho(String nome) {
        this.nome = nome;
    }
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
