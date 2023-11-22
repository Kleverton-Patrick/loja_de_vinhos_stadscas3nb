package br.com.lojavinho.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    public class Compras {

        private int numSequencia;
        private LocalDateTime dataOperacao;
        private BigDecimal valorTotalVenda;
        private String cpfCliente;

        private String numSeqPag;

        private String numSeqEntrega;

        public Compras(LocalDateTime dataOperacao, BigDecimal valorTotalVenda, String cpfCliente, String numSeqPag, String numSeqEntrega) {
            this.dataOperacao = dataOperacao;
            this.valorTotalVenda = valorTotalVenda;
            this.cpfCliente = cpfCliente;
            this.numSeqPag = numSeqPag;
            this.numSeqEntrega = numSeqEntrega;
        }

        public Compras() {

        }

        public String getNumSeqPag() {
            return numSeqPag;
        }

        public void setNumSeqPag(String numSeqPag) {
            this.numSeqPag = numSeqPag;
        }

        public String getNumSeqEntrega() {
            return numSeqEntrega;
        }

        public void setNumSeqEntrega(String numSeqEntrega) {
            this.numSeqEntrega = numSeqEntrega;
        }

        public int getNumSequencia() {
            return numSequencia;
        }

        public void setNumSequencia(int numSequencia) {
            this.numSequencia = numSequencia;
        }

        public LocalDateTime getDataOperacao() {
            return dataOperacao;
        }

        public void setDataOperacao(LocalDateTime dataOperacao) {
            this.dataOperacao = dataOperacao;
        }

        public BigDecimal getValorTotalVenda() {
            return valorTotalVenda;
        }

        public void setValorTotalVenda(BigDecimal valorTotalVenda) {
            this.valorTotalVenda = valorTotalVenda;
        }

        public String getCpfCliente() {
            return cpfCliente;
        }

        public void setCpfCliente(String cpfCliente) {
            this.cpfCliente = cpfCliente;
        }

        @Override
        public String toString() {
            return "Compra{" +
                    "numSequencia=" + numSequencia +
                    ", dataOperacao=" + dataOperacao +
                    ", valorTotalVenda=" + valorTotalVenda +
                    ", cpfCliente='" + cpfCliente + '\'' +
                    '}';
        }
    }


