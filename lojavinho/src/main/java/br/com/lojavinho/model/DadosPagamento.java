package br.com.lojavinho.model;

import java.sql.Date;


public class DadosPagamento {
    private int numSequencia;
    private String numCPF;
    private String nomeCartao;
    private String numCartao;
    private int cvc;
    private String dataValidade;

    public DadosPagamento(int numSequencia, String numCPF, String nomeCartao, String numCartao, int cvc, String dataValidade) {
        this.numSequencia = numSequencia;
        this.numCPF = numCPF;
        this.nomeCartao = nomeCartao;
        this.numCartao = numCartao;
        this.cvc = cvc;
        this.dataValidade = dataValidade;
    }

    public DadosPagamento(String numCPF, String nomeCartao, String numCartao, String dataValidade, int cvc) {

        this.numCPF = numCPF;
        this.nomeCartao = nomeCartao;
        this.numCartao = numCartao;
        this.cvc = cvc;
        this.dataValidade = dataValidade;
    }


    public String getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(String numCPF) {
        this.numCPF = numCPF;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade =  dataValidade;
    }
}
