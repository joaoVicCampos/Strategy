package org.modelo;

public class PagamentoCartao implements EstrategiaPagamento {

    @Override
    public double calcularValorFinal(double valor) {
        return valor * 1.05;
    }

    @Override
    public String getNome() {
        return "Cartão de Crédito";
    }
}

