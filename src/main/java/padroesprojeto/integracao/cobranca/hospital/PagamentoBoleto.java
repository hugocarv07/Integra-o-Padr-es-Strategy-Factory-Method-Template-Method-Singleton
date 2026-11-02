package padroesprojeto.integracao.cobranca.hospital;

public class PagamentoBoleto implements FormaPagamento {

    public float calcular(float valor, float taxaEmissao) {
        return valor + taxaEmissao;
    }
}
