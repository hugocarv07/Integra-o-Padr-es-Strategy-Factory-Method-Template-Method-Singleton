package padroesprojeto.integracao.cobranca.hospital;

import java.util.Locale;

/**
 * Integra quatro padrões:
 *
 * - Template Method: processar() é o esqueleto fixo (final); as subclasses só
 *   definem getValorBase() e getTipoCobranca().
 * - Factory Method: a forma de pagamento é obtida pelo nome em
 *   FormaPagamentoFactory.obterFormaPagamento(...).
 * - Strategy: CalculadoraPagamento delega o cálculo à FormaPagamento obtida.
 * - Singleton: o resultado é registrado no único RegistroFinanceiro.
 */
public abstract class Cobranca {

    public final String processar(String tipoPagamento, float condicao) {
        float valorBase = getValorBase();
        FormaPagamento forma = FormaPagamentoFactory.obterFormaPagamento(tipoPagamento);
        float valorAPagar = new CalculadoraPagamento(valorBase, condicao).calcular(forma);
        RegistroFinanceiro.getInstance().registrar(getTipoCobranca(), valorAPagar);
        return gerarComprovante(tipoPagamento, valorAPagar);
    }

    // Passos obrigatórios: cada subclasse define o seu
    protected abstract float getValorBase();

    protected abstract String getTipoCobranca();

    // Passo com implementação padrão (hook)
    protected String gerarComprovante(String tipoPagamento, float valorAPagar) {
        return String.format(Locale.forLanguageTag("pt-BR"), "%s | %s | R$ %.2f",
                getTipoCobranca(), tipoPagamento, valorAPagar);
    }
}
