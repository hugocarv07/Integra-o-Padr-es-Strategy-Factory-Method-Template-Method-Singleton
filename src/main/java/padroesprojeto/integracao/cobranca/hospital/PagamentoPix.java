package padroesprojeto.integracao.cobranca.hospital;

public class PagamentoPix implements FormaPagamento {

    public float calcular(float valor, float descontoPercentual) {
        return valor - (valor * descontoPercentual / 100);
    }
}
