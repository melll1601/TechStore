package TechStore;

public class CalculoFreteImpostos {
    public double calculoFrete(Pedido pedido){

        double frete = 0.0;

        if (pedido.getValorTotal() < 500.00){
            frete = 50.00;
        }else {
            frete = 0.0;
        }

        return frete;
    }
    public double calculoImpostos(Pedido pedido){

        double impostos = pedido.getValorTotal() * 0.15;
        return impostos;
    }

}
