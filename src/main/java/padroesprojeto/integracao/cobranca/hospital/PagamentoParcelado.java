package padroesprojeto.integracao.cobranca.hospital;

public class PagamentoParcelado implements FormaPagamento {

    public float calcular(float valor, float parcelas) {
        if (parcelas <= 0) {
            throw new IllegalArgumentException("Número de parcelas inválido");
        }
        return valor / parcelas;
    }
}
