package padroesprojeto.integracao.cobranca.hospital;

public class RegistroFinanceiro {

    private RegistroFinanceiro() {};
    private static RegistroFinanceiro instance = new RegistroFinanceiro();
    public static RegistroFinanceiro getInstance() {
        return instance;
    }

    private float totalCobrado;
    private int quantidadeCobrancas;

    public void registrar(String tipoCobranca, float valor) {
        this.totalCobrado += valor;
        this.quantidadeCobrancas++;
    }

    public float getTotalCobrado() {
        return totalCobrado;
    }

    public int getQuantidadeCobrancas() {
        return quantidadeCobrancas;
    }

    public void limpar() {
        this.totalCobrado = 0;
        this.quantidadeCobrancas = 0;
    }
}
