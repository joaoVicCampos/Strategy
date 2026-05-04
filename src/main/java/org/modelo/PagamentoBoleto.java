package org.modelo;

public class PagamentoBoleto implements EstrategiaPagamento {

    @Override
    public double calcularValorFinal(double valor) {
        return valor;
    }

    @Override
    public String getNome() {
        return "Boleto";
    }
}

