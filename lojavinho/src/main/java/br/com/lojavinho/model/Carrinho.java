package br.com.lojavinho.model;

public class Carrinho {

    private String numCPF;
    private int qtdTotal;
    private double vlrTotal;

    public Carrinho() {
    }

    public Carrinho(String numCPF, int qtdTotal, double vlrTotal) {
        this.numCPF = numCPF;
        this.qtdTotal = qtdTotal;
        this.vlrTotal = vlrTotal;
    }

    public String getNumCPF() {
        return numCPF;
    }

    public int getQtdTotal() {
        return qtdTotal;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setNumCPF(String numCPF) {
        this.numCPF = numCPF;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }
}
