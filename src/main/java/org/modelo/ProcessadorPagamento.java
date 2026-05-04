package org.modelo;

public class ProcessadorPagamento {
    private EstrategiaPagamento estrategiaPagamento;

    public ProcessadorPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    public void setEstrategiaPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    public void processarPagamento(double valorCompra) {
        double valorFinal = estrategiaPagamento.calcularValorFinal(valorCompra);

        System.out.println("Estratégia escolhida: " + estrategiaPagamento.getNome());
        System.out.println("Valor original: R$ " + String.format("%.2f", valorCompra));
        System.out.println("Valor final: R$ " + String.format("%.2f", valorFinal));
        System.out.println("------------------------------");
    }
}

