package padroesprojeto.integracao.cobranca.hospital;

public class PagamentoEntrada implements FormaPagamento {

    public float calcular(float valor, float entrada) {
        if (entrada > valor) {
            throw new IllegalArgumentException("Entrada maior que o valor");
        }
        return valor - entrada;
    }
}
