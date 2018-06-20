package dominio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<Locacao> locacaos;
    private double valorTotal;
    private StatusPedido status;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.locacaos = new ArrayList<>();
        this.valorTotal = 0;
        this.status = StatusPedido.ATIVO;
    }

    public void adicionaFita(Fita fita) {
        if (status == StatusPedido.ATIVO) {
            Locacao locacao = new Locacao(fita, fita.getPrazo());
            locacaos.add(locacao);
            fita.loca();
            calcularValorTotal();
        }
    }

    public void calcularValorTotal() {
        this.valorTotal = 0;
        for (Locacao locacao : locacaos) {
            this.valorTotal += locacao.getFita().getValor();
        }
    }

    public void devolveFita(Fita fita) {
        if (status == StatusPedido.PENDENTE) {
            Locacao locacao = locacaos.stream().filter(p -> p.getFita().equals(fita)).findFirst().orElseThrow(() -> new RuntimeException("Essa fita não está locada neste pedido"));
            fita.entrega();
            locacao.devolve();
            locacaos.remove(locacao);
            calcularValorTotal();
        }
    }
}
