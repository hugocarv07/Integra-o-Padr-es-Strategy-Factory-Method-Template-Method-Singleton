package padroesprojeto.integracao.cobranca.hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CobrancaTest {

    @BeforeEach
    void setUp() {
        RegistroFinanceiro.getInstance().limpar();
    }

    @Test
    void deveProcessarConsultaComPix() {
        assertEquals("Consulta | Pix | R$ 180,00", new CobrancaConsulta().processar("Pix", 10.0f));
    }

    @Test
    void deveProcessarConsultaComBoleto() {
        assertEquals("Consulta | Boleto | R$ 203,50", new CobrancaConsulta().processar("Boleto", 3.5f));
    }

    @Test
    void deveProcessarExameComCartaoCredito() {
        assertEquals("Exame | CartaoCredito | R$ 165,00", new CobrancaExame().processar("CartaoCredito", 10.0f));
    }

    @Test
    void deveProcessarExameComEntrada() {
        assertEquals("Exame | Entrada | R$ 100,00", new CobrancaExame().processar("Entrada", 50.0f));
    }

    @Test
    void deveProcessarInternacaoParcelada() {
        assertEquals("Internação | Parcelado | R$ 400,00", new CobrancaInternacao().processar("Parcelado", 3.0f));
    }

    @Test
    void naoDeveProcessarComFormaDePagamentoInexistente() {
        try {
            new CobrancaConsulta().processar("Cheque", 0.0f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Forma de pagamento inexistente", e.getMessage());
        }
    }

    @Test
    void naoDeveProcessarComFormaDePagamentoInvalida() {
        try {
            new CobrancaConsulta().processar("Estorno", 0.0f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Forma de pagamento inválida", e.getMessage());
        }
    }

    @Test
    void naoDeveRegistrarNoRegistroFinanceiroQuandoOCalculoFalha() {
        try {
            new CobrancaInternacao().processar("Parcelado", 0.0f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Número de parcelas inválido", e.getMessage());
        }
        assertEquals(0, RegistroFinanceiro.getInstance().getQuantidadeCobrancas());
        assertEquals(0.0f, RegistroFinanceiro.getInstance().getTotalCobrado(), 0.01f);
    }
}
