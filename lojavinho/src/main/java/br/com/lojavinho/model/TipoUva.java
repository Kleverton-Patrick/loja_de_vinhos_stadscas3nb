package br.com.lojavinho.model;

public class TipoUva {
    private int tipoUvaID;
    private String nomeTipoUva;

    public TipoUva()
    {
    }

    public TipoUva(int tipoUvaID, String nomeTipoUva)

    {
        this.tipoUvaID = tipoUvaID;
        this.nomeTipoUva = nomeTipoUva;
    }

    public int getTipoUvaID()
    {
        return tipoUvaID;
    }

    public void setTipoUvaID(int tipoUvaID)
    {
        this.tipoUvaID = tipoUvaID;
    }

    public String getNomeTipoUva()
    {
        return nomeTipoUva;
    }

    public void setNomeTipoUva(String nomeTipoUva)
    {
        this.nomeTipoUva = nomeTipoUva;
    }
}
