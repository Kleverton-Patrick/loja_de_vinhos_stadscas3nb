package br.com.lojavinho.model;

import java.math.BigDecimal;


    public class ItemCompra {
        private int numSequencia;
        private String descNomeVinho;
        private int qtdVendidaProduto;
        private BigDecimal vlrVendidoProduto;
        private int fkNumSeqVinho;
        private int fkNumSeqCompra;

        public ItemCompra() {

        }

        public ItemCompra(int numSequencia, String descNomeVinho, int qtdVendidaProduto, BigDecimal vlrVendidoProduto, int fkNumSeqVinho, int fkNumSeqCompra) {
            this.numSequencia = numSequencia;
            this.descNomeVinho = descNomeVinho;
            this.qtdVendidaProduto = qtdVendidaProduto;
            this.vlrVendidoProduto = vlrVendidoProduto;
            this.fkNumSeqVinho = fkNumSeqVinho;
            this.fkNumSeqCompra = fkNumSeqCompra;
        }

        public int getNumSequencia() {
            return numSequencia;
        }

        public void setNumSequencia(int numSequencia) {
            this.numSequencia = numSequencia;
        }

        public String getDescNomeVinho() {
            return descNomeVinho;
        }

        public void setDescNomeVinho(String descNomeVinho) {
            this.descNomeVinho = descNomeVinho;
        }

        public int getQtdVendidaProduto() {
            return qtdVendidaProduto;
        }

        public void setQtdVendidaProduto(int qtdVendidaProduto) {
            this.qtdVendidaProduto = qtdVendidaProduto;
        }

        public BigDecimal getVlrVendidoProduto() {
            return vlrVendidoProduto;
        }

        public void setVlrVendidoProduto(BigDecimal vlrVendidoProduto) {
            this.vlrVendidoProduto = vlrVendidoProduto;
        }

        public int getFkNumSeqVinho() {
            return fkNumSeqVinho;
        }

        public void setFkNumSeqVinho(int fkNumSeqVinho) {
            this.fkNumSeqVinho = fkNumSeqVinho;
        }

        public int getFkNumSeqCompra() {
            return fkNumSeqCompra;
        }

        public void setFkNumSeqCompra(int fkNumSeqCompra) {
            this.fkNumSeqCompra = fkNumSeqCompra;
        }
    }


