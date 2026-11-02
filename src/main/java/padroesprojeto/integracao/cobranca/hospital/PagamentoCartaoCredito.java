package padroesprojeto.integracao.cobranca.hospital;

public class PagamentoCartaoCredito implements FormaPagamento {

    public float calcular(float valor, float jurosPercentual) {
        return valor * (1 + jurosPercentual / 100);
    }
}
