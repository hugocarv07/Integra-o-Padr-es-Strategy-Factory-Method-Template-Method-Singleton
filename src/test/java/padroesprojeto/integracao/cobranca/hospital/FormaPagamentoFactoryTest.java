package padroesprojeto.integracao.cobranca.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormaPagamentoFactoryTest {

    @Test
    void deveObterCadaFormaDePagamentoPeloNome() {
        assertTrue(FormaPagamentoFactory.obterFormaPagamento("Boleto") instanceof PagamentoBoleto);
        assertTrue(FormaPagamentoFactory.obterFormaPagamento("Pix") instanceof PagamentoPix);
        assertTrue(FormaPagamentoFactory.obterFormaPagamento("CartaoCredito") instanceof PagamentoCartaoCredito);
        assertTrue(FormaPagamentoFactory.obterFormaPagamento("Parcelado") instanceof PagamentoParcelado);
        assertTrue(FormaPagamentoFactory.obterFormaPagamento("Entrada") instanceof PagamentoEntrada);
    }

    @Test
    void deveRetornarExcecaoParaFormaDePagamentoInexistente() {
        try {
            FormaPagamentoFactory.obterFormaPagamento("Cheque");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Forma de pagamento inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaFormaDePagamentoInvalida() {
        try {
            FormaPagamentoFactory.obterFormaPagamento("Estorno");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Forma de pagamento inválida", e.getMessage());
        }
    }
}
