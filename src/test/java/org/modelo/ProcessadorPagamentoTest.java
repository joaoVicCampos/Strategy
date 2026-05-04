package org.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessadorPagamentoTest {


    @Test
    void deveAplicarAcrescimoNoCartao() {
        ProcessadorPagamento processador = new ProcessadorPagamento(new PagamentoCartao());
        processador.processarPagamento(100.0);
        assertEquals(105.0, new PagamentoCartao().calcularValorFinal(100.0));
    }

    @Test
    void deveRetornarNomeCartao() {
        EstrategiaPagamento estrategia = new PagamentoCartao();
        assertEquals("Cartão de Crédito", estrategia.getNome());
    }

    @Test
    void deveAplicarAcrescimoCartaoEmValorZero() {
        EstrategiaPagamento estrategia = new PagamentoCartao();
        assertEquals(0.0, estrategia.calcularValorFinal(0.0));
    }

    @Test
    void deveAplicarDescontoPix() {
        EstrategiaPagamento estrategia = new PagamentoPix();
        assertEquals(90.0, estrategia.calcularValorFinal(100.0));
    }

    @Test
    void deveRetornarNomePix() {
        EstrategiaPagamento estrategia = new PagamentoPix();
        assertEquals("PIX", estrategia.getNome());
    }

    @Test
    void deveAplicarDescontoPixEmValorZero() {
        EstrategiaPagamento estrategia = new PagamentoPix();
        assertEquals(0.0, estrategia.calcularValorFinal(0.0));
    }


    @Test
    void deveManterValorOriginalNoBoleto() {
        EstrategiaPagamento estrategia = new PagamentoBoleto();
        assertEquals(100.0, estrategia.calcularValorFinal(100.0));
    }

    @Test
    void deveRetornarNomeBoleto() {
        EstrategiaPagamento estrategia = new PagamentoBoleto();
        assertEquals("Boleto", estrategia.getNome());
    }

    @Test
    void deveManterValorZeroNoBoleto() {
        EstrategiaPagamento estrategia = new PagamentoBoleto();
        assertEquals(0.0, estrategia.calcularValorFinal(0.0));
    }


    @Test
    void deveTrocarEstrategiaEmTempoDeExecucao() {
        ProcessadorPagamento processador = new ProcessadorPagamento(new PagamentoCartao());

        processador.setEstrategiaPagamento(new PagamentoPix());

        // após trocar para Pix, o cálculo deve aplicar desconto de 10%
        double valorFinal = new PagamentoPix().calcularValorFinal(200.0);
        assertEquals(180.0, valorFinal);
    }

    @Test
    void deveCalcularValorCartaoComValorAlto() {
        EstrategiaPagamento estrategia = new PagamentoCartao();
        assertEquals(1050.0, estrategia.calcularValorFinal(1000.0));
    }

    @Test
    void deveCalcularDescontoPixComValorAlto() {
        EstrategiaPagamento estrategia = new PagamentoPix();
        assertEquals(900.0, estrategia.calcularValorFinal(1000.0));
    }
}
