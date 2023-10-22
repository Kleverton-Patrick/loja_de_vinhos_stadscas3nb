package br.com.lojavinho.model;

public class TipoVinho {
    private int tipoVinhoID;
    private String nomeTipoVinho;

    public TipoVinho()
    {
    }

    public TipoVinho(int tipoVinhoID, String nomeTipoVinho)
    {
        this.tipoVinhoID = tipoVinhoID;
        this.nomeTipoVinho = nomeTipoVinho;
    }

    public int getTipoVinhoID()
    {
        return tipoVinhoID;
    }

    public void setTipoVinhoID(int tipoVinhoID)
    {
        this.tipoVinhoID = tipoVinhoID;
    }

    public String getNomeTipoVinho()
    {
        return nomeTipoVinho;
    }

    public void setNomeTipoVinho(String nomeTipoVinho)
    {
        this.nomeTipoVinho = nomeTipoVinho;
    }
}
