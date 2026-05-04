package org.modelo;

public interface EstrategiaPagamento {
    double calcularValorFinal(double valor);
    String getNome();
}

