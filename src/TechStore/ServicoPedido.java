package TechStore;

public class ServicoPedido {

    private ValidacaoEstoque validacaoEstoque = new ValidacaoEstoque();
    private CalculoFreteImpostos calculoFreteImpostos = new CalculoFreteImpostos();
    private PersistenciaPedido persistenciaPedido = new PersistenciaPedido();
    private EnviarEmail enviarEmail = new EnviarEmail();

    public double processarPedido(Pedido pedido) throws Exception{

        validacaoEstoque.validarQuantidadeItens(pedido);

        double frete = calculoFreteImpostos.calculoFrete(pedido);
        double impostos = calculoFreteImpostos.calculoImpostos(pedido);
        double valorFinal = pedido.getValorTotal() + frete + impostos;

        pedido.setPago(true);

        persistenciaPedido.salvarBanco(pedido, valorFinal);
        enviarEmail.enviarConfirmacaoPorEmail(pedido.getEmailCliente(), pedido.getId());

        return valorFinal;
    }
}

