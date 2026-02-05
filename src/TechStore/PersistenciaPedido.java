package TechStore;

public class PersistenciaPedido {
    public void salvarBanco(Pedido pedido, double valorFinal){
        System.out.println("Pedido " + pedido.getId() + " finalizado (Valor: R$" + valorFinal + ") e salvo no BD.");
    }
}
