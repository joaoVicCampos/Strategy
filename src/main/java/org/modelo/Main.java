package org.modelo;

public class Main {
    public static void main(String[] args) {
        double valorCompra = 100.00;
        ProcessadorPagamento processador = new ProcessadorPagamento(new PagamentoCartao());

        processador.processarPagamento(valorCompra);

        processador.setEstrategiaPagamento(new PagamentoPix());
        processador.processarPagamento(valorCompra);

        processador.setEstrategiaPagamento(new PagamentoBoleto());
        processador.processarPagamento(valorCompra);
    }
}
