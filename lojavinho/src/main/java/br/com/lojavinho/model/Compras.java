package br.com.lojavinho.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    public class Compras {

        private int numSequencia;
        private LocalDateTime dataOperacao;
        private BigDecimal valorTotalVenda;
        private String cpfCliente;

        public Compras(LocalDateTime dataOperacao, BigDecimal valorTotalVenda, String cpfCliente) {

            this.dataOperacao = dataOperacao;
            this.valorTotalVenda = valorTotalVenda;
            this.cpfCliente = cpfCliente;
        }

        public Compras() {

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


