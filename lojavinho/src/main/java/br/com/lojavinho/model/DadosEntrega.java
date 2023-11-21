package br.com.lojavinho.model;

public class DadosEntrega {


    private String numCPF;
    private String CEP;
    private String endereco;
    private String numEndereco;
    private String complEndereco;
    private String bairro;
    private String cidade;
    private String estado;

    public DadosEntrega(String numCPF, String CEP, String endereco, String numEndereco, String complEndereco, String bairro, String cidade, String estado) {
        this.numCPF = numCPF;
        this.CEP = CEP;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.complEndereco = complEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(String numCPF) {
        this.numCPF = numCPF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getComplEndereco() {
        return complEndereco;
    }

    public void setComplEndereco(String complEndereco) {
        this.complEndereco = complEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

