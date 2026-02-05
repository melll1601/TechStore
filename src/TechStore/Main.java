package TechStore;

import TechStore.Pedido;
import TechStore.ServicoPedido;

public class Main {
    public static void main(String[] args) {
        ServicoPedido processador = new ServicoPedido();
        Pedido pedido1 = new Pedido("PED-123", 600.00, 5, "cliente@email.com");

        try {
            double total = processador.processarPedido(pedido1);
            System.out.println("Resultado final: Pedido processado com sucesso! Total: R$" + total);
        } catch (Exception e) {
            System.out.println("Erro ao processar pedido: " + e.getMessage());
        }

    }
}