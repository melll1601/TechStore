package TechStore;

public class Pedido {
    private String id;
    private double valorTotal;
    private int quantidadeItens;
    private boolean isPago;
    private String emailCliente;
    public Pedido(String id, double valorTotal, int quantidadeItens, String
            emailCliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.quantidadeItens = quantidadeItens;
        this.isPago = false;
        this.emailCliente = emailCliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        isPago = pago;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
