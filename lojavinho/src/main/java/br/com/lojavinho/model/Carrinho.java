package br.com.lojavinho.model;

public class Carrinho {

    private String numCPF;
    private String qtdTotal;
    private String vlrTotal;


    public Carrinho(String numCPF, String qtdTotal, String vlrTotal) {
        this.numCPF = numCPF;
        this.qtdTotal = qtdTotal;
        this.vlrTotal = vlrTotal;
    }

    public String getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(String numCPF) {
        this.numCPF = numCPF;
    }

    public String getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(String qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public String getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(String vlrTotal) {
        this.vlrTotal = vlrTotal;
    }
}