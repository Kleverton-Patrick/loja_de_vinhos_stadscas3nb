package br.com.lojavinho.model;

public class Pais {
    private int paisID;
    private String nomePais;

    public Pais() {
    }

    public Pais(int paisID, String nomePais) {
        this.nomePais = nomePais;
        this.paisID = paisID;
    }

    public int getpaisID()
    {
        return paisID;
    }

    public void setpaisID(int paisID)
    {
        this.paisID = paisID;
    }

    public String getNomePais()
    {
        return nomePais;
    }

    public void setNomePais(String nomePais)
    {
        this.nomePais = nomePais;
    }

}
