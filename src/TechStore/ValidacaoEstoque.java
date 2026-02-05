package TechStore;

public class ValidacaoEstoque {

    public void validarQuantidadeItens(Pedido pedido) throws Exception {

        if (pedido.getQuantidadeItens() > 100){
            throw new Exception("Estoque insuficiente para a quantidade solicitada.");
        }
    }
}
