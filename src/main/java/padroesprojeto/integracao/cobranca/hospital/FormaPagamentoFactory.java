package padroesprojeto.integracao.cobranca.hospital;

public class FormaPagamentoFactory {

    public static FormaPagamento obterFormaPagamento(String tipo) {
        try {
            Class<?> classe = Class.forName(
                    "padroesprojeto.integracao.cobranca.hospital.Pagamento" + tipo);
            Object objeto = classe.getDeclaredConstructor().newInstance();
            return (FormaPagamento) objeto;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Forma de pagamento inexistente");
        } catch (Exception e) {
            throw new IllegalArgumentException("Forma de pagamento inválida");
        }
    }
}
