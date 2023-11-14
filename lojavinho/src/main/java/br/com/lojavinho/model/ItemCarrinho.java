package br.com.lojavinho.model;

public class ItemCarrinho {

    private int seqItem;
    private int numSeqVinho;
    private int qtdProduto;
    private double vlrProduto;
    private String numCPF;

    public ItemCarrinho() {
    }

    public ItemCarrinho(int numSeqVinho, int qtdProduto, double vlrProduto, String numCPF) {
        this.numSeqVinho = numSeqVinho;
        this.qtdProduto = qtdProduto;
        this.vlrProduto = vlrProduto;
        this.numCPF = numCPF;
    }

    public ItemCarrinho(int seqItem, int numSeqVinho, int qtdProduto, double vlrProduto, String numCPF) {
        this.seqItem = seqItem;
        this.numSeqVinho = numSeqVinho;
        this.qtdProduto = qtdProduto;
        this.vlrProduto = vlrProduto;
        this.numCPF = numCPF;
    }

    public int getSeqItem() {
        return seqItem;
    }

    public int getNumSeqVinho() {
        return numSeqVinho;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public double getVlrProduto() {
        return vlrProduto;
    }

    public String getNumCPF() {
        return numCPF;
    }

    public void setSeqItem(int seqItem) {
        this.seqItem = seqItem;
    }

    public void setNumSeqVinho(int numSeqVinho) {
        this.numSeqVinho = numSeqVinho;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public void setVlrProduto(double vlrProduto) {
        this.vlrProduto = vlrProduto;
    }

    public void setNumCPF(String numCPF) {
        this.numCPF = numCPF;
    }
}
