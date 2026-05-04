package org.modelo;

public class PagamentoPix implements EstrategiaPagamento {

    @Override
    public double calcularValorFinal(double valor) {
        return valor * 0.90;
    }

    @Override
    public String getNome() {
        return "PIX";
    }
}

