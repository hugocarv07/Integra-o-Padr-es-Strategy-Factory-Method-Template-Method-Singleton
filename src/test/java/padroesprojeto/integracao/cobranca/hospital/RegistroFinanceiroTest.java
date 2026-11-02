package padroesprojeto.integracao.cobranca.hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroFinanceiroTest {

    @BeforeEach
    void setUp() {
        RegistroFinanceiro.getInstance().limpar();
    }

    @Test
    void deveRetornarSempreAMesmaInstanciaDoRegistro() {
        assertSame(RegistroFinanceiro.getInstance(), RegistroFinanceiro.getInstance());
    }

    @Test
    void deveAcumularAsCobrancasDeTodosOsTiposNoMesmoRegistro() {
        new CobrancaConsulta().processar("Pix", 10.0f);          // 180,00
        new CobrancaExame().processar("Entrada", 50.0f);         // 100,00
        new CobrancaInternacao().processar("Parcelado", 3.0f);   // 400,00

        assertEquals(3, RegistroFinanceiro.getInstance().getQuantidadeCobrancas());
        assertEquals(680.0f, RegistroFinanceiro.getInstance().getTotalCobrado(), 0.01f);
    }

    @Test
    void deveZerarORegistroAoLimpar() {
        new CobrancaConsulta().processar("Pix", 10.0f);
        RegistroFinanceiro.getInstance().limpar();

        assertEquals(0, RegistroFinanceiro.getInstance().getQuantidadeCobrancas());
        assertEquals(0.0f, RegistroFinanceiro.getInstance().getTotalCobrado(), 0.01f);
    }
}
