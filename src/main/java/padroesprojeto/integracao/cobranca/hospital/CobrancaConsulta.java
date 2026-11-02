package padroesprojeto.integracao.cobranca.hospital;

public class CobrancaConsulta extends Cobranca {

    protected float getValorBase() {
        return 200.0f;
    }

    protected String getTipoCobranca() {
        return "Consulta";
    }
}
