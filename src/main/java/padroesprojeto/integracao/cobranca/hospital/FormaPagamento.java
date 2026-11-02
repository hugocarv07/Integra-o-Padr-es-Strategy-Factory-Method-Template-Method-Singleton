package padroesprojeto.integracao.cobranca.hospital;

public interface FormaPagamento {

    float calcular(float valor, float condicao);
}
