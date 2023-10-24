package br.com.lojavinho.model;

public class Pais {
    private int paisID;
    private String nomePais;

    public Pais() {
    }

    public Pais(int paisID, String nomePais) {
        this.paisID = paisID;
        this.nomePais = nomePais;
    }

    public int getPaisID() {
        return paisID;
    }

    public void setPaisID(int paisID) {
        this.paisID = paisID;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
