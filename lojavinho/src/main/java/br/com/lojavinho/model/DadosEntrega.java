package br.com.lojavinho.model;

public class DadosEntrega {

    private int numSequencia;
    private String nomeCliente;
    private String numCartaoCredito;
    private String codCEP;
    private String endereco;
    private int numEndereco;
    private String complEndereco;
    private String bairro;
    private String cidade;
    private String estado;
    private int fkNumSeqCompra;


    public DadosEntrega(int numSequencia, String nomeCliente, String numCartaoCredito, String codCEP,
                        String endereco, int numEndereco, String complEndereco, String bairro, String cidade,
                        String estado, int fkNumSeqCompra) {
        this.numSequencia = numSequencia;
        this.nomeCliente = nomeCliente;
        this.numCartaoCredito = numCartaoCredito;
        this.codCEP = codCEP;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.complEndereco = complEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.fkNumSeqCompra = fkNumSeqCompra;
    }

    public DadosEntrega(String codCep, String endereco, String enderecoComplemento,
                        String bairro, String cidade, String estado) {
        this.codCEP = codCep;
        this.endereco = endereco;
        this.complEndereco = enderecoComplemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }



    public int getNumSequencia() {
        return numSequencia;
    }

    public void setNumSequencia(int numSequencia) {
        this.numSequencia = numSequencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumCartaoCredito() {
        return numCartaoCredito;
    }

    public void setNumCartaoCredito(String numCartaoCredito) {
        this.numCartaoCredito = numCartaoCredito;
    }

    public String getCodCEP() {
        return codCEP;
    }

    public void setCodCEP(String codCEP) {
        this.codCEP = codCEP;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(int numEndereco) {
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

    public int getFkNumSeqCompra() {
        return fkNumSeqCompra;
    }

    public void setFkNumSeqCompra(int fkNumSeqCompra) {
        this.fkNumSeqCompra = fkNumSeqCompra;
    }

}

