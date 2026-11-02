package padroesprojeto.integracao.cobranca.hospital;

public class CalculadoraPagamento {

    private float valor;
    private float condicao;

    public CalculadoraPagamento(float valor, float condicao) {
        this.valor = valor;
        this.condicao = condicao;
    }

    public float calcular(FormaPagamento formaPagamento) {
        return formaPagamento.calcular(this.valor, this.condicao);
    }
}
