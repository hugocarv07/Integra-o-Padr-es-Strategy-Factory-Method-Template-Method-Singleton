package padroesprojeto.integracao.cobranca.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormaPagamentoTest {

    @Test
    void devePermitirTrocarAFormaDePagamentoNaMesmaCalculadora() {
        CalculadoraPagamento calculadora = new CalculadoraPagamento(200.0f, 10.0f);

        assertEquals(180.0f, calculadora.calcular(new PagamentoPix()), 0.01f);
        assertEquals(210.0f, calculadora.calcular(new PagamentoBoleto()), 0.01f);
        assertEquals(220.0f, calculadora.calcular(new PagamentoCartaoCredito()), 0.01f);
        assertEquals(20.0f, calculadora.calcular(new PagamentoParcelado()), 0.01f);
        assertEquals(190.0f, calculadora.calcular(new PagamentoEntrada()), 0.01f);
    }

    @Test
    void naoDeveCalcularParceladoComZeroParcelas() {
        try {
            new CalculadoraPagamento(300.0f, 0.0f).calcular(new PagamentoParcelado());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Número de parcelas inválido", e.getMessage());
        }
    }

    @Test
    void naoDeveCalcularEntradaMaiorQueOValor() {
        try {
            new CalculadoraPagamento(500.0f, 600.0f).calcular(new PagamentoEntrada());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Entrada maior que o valor", e.getMessage());
        }
    }
}
