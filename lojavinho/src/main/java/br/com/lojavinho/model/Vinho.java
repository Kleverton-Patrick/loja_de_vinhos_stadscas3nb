package br.com.lojavinho.model;
///
public class Vinho {

    private String id;
    private String nome;
    private String descricao;
    private String valor;
    private String estoque;
    private String imagem;


    public Vinho(String id, String nome, String valor, String estoque, String descricao, String imagem) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
        this.descricao = descricao;
        this.imagem = imagem;
    }


    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getImagem() {
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {return valor;}

    public String getEstoque() {return estoque;}
}
