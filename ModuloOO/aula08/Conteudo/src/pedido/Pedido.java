package pedido;

public class Pedido {

    private StatusPedido statusPedido;

    public Pedido() {
        this.statusPedido = StatusPedido.ABERTO;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }
}
