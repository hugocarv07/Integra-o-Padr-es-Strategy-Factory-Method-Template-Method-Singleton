package padroesprojeto.integracao.cobranca.hospital;

public class CobrancaInternacao extends Cobranca {

    protected float getValorBase() {
        return 1200.0f;
    }

    protected String getTipoCobranca() {
        return "Internação";
    }
}
