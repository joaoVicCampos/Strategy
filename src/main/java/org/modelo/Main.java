package org.modelo;

public class Main {
    public static void main(String[] args) {
        double valorCompra = 100.00;
        exibirPagamento(valorCompra, new PagamentoCartao());
        exibirPagamento(valorCompra, new PagamentoPix());
        exibirPagamento(valorCompra, new PagamentoBoleto());
    }

    private static void exibirPagamento(double valorCompra, EstrategiaPagamento estrategiaPagamento) {
        double valorFinal = estrategiaPagamento.calcularValorFinal(valorCompra);

        System.out.println("Estratégia escolhida: " + estrategiaPagamento.getNome());
        System.out.println("Valor original: R$ " + String.format("%.2f", valorCompra));
        System.out.println("Valor final: R$ " + String.format("%.2f", valorFinal));
        System.out.println("------------------------------");
    }
}
