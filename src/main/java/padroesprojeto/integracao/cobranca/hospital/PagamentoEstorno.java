package padroesprojeto.integracao.cobranca.hospital;

/**
 * Operação interna de estorno. Segue a convenção de nomes usada pela
 * FormaPagamentoFactory ("Pagamento" + tipo), mas não é uma forma de
 * pagamento: não implementa FormaPagamento. Serve para demonstrar o caso
 * em que a classe existe, porém é inválida como produto da fábrica.
 */
public class PagamentoEstorno {

    public String registrarEstorno() {
        return "Estorno registrado";
    }
}
