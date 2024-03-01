package br.com.lojavinho.model;

public class ItemCarrinho {

    private String seqItem;
    private String numSeqVinho;
    private String descNomeVinho;
    private String qtdProduto;
    private String vlrProduto;
    private String numCPF;
    private String imagem;

    public ItemCarrinho() {
    }
    public ItemCarrinho(String numSeqVinho, String descNomeVinho, String qtdProduto, String vlrProduto, String numCPF, String imagem) {
        this.numSeqVinho = numSeqVinho;
        this.descNomeVinho = descNomeVinho;
        this.qtdProduto = qtdProduto;
        this.vlrProduto = vlrProduto;
        this.numCPF = numCPF;
        this.imagem = imagem;
    }

    public ItemCarrinho(String seqItem, String numSeqVinho, String descNomeVinho, String qtdProduto, String vlrProduto, String numCPF, String imagem) {
        this.seqItem = seqItem;
        this.numSeqVinho = numSeqVinho;
        this.descNomeVinho = descNomeVinho;
        this.qtdProduto = qtdProduto;
        this.vlrProduto = vlrProduto;
        this.numCPF = numCPF;
        this.imagem = imagem;
    }

    public String getSeqItem() {
        return seqItem;
    }

    public void setSeqItem(String seqItem) {
        this.seqItem = seqItem;
    }

    public String getNumSeqVinho() {
        return numSeqVinho;
    }

    public void setNumSeqVinho(String numSeqVinho) {
        this.numSeqVinho = numSeqVinho;
    }

    public String getDescNomeVinho() {
        return descNomeVinho;
    }

    public void setDescNomeVinho(String descNomeVinho) {
        this.descNomeVinho = descNomeVinho;
    }

    public String getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(String qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getVlrProduto() {
        return vlrProduto;
    }

    public void setVlrProduto(String vlrProduto) {
        this.vlrProduto = vlrProduto;
    }

    public String getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(String numCPF) {
        this.numCPF = numCPF;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
