package padroesprojeto.integracao.cobranca.hospital;

public class CobrancaExame extends Cobranca {

    protected float getValorBase() {
        return 150.0f;
    }

    protected String getTipoCobranca() {
        return "Exame";
    }
}
