package dominio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<Locacao> locacoes;
    private double valorTotal;
    private StatusPedido status;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.locacoes = new ArrayList<>();
        this.valorTotal = 0;
        this.status = StatusPedido.ATIVO;
    }

    public void adicionaFita(Fita fita) {
        if (status == StatusPedido.ATIVO) {
            Locacao locacao = new Locacao(fita);
            locacoes.add(locacao);
            fita.loca();
            calcularValorTotal();
            this.status = StatusPedido.PENDENTE;
        }
    }

    public void adicionarFitas(List<Fita> novasFitas){
        if(status == StatusPedido.ATIVO){
            for(Fita fita : novasFitas){
                fita.loca();
                Locacao locacao = new Locacao(fita);
                locacoes.add(locacao);
            }
        }
        calcularValorTotal();
        status = StatusPedido.PENDENTE;
    }

    public void calcularValorTotal() {
        this.valorTotal = 0;
        for (Locacao locacao : locacoes) {
            this.valorTotal += locacao.getFita().getValor();
        }
    }

    public void devolveFita(Fita fita) {
        if (status == StatusPedido.PENDENTE) {
            Locacao locacao = locacoes.stream().filter(p -> p.getFita().equals(fita)).findFirst().orElseThrow(() -> new RuntimeException("Essa fita não está locada neste pedido"));
            locacao.devolve();
            locacao.getFita().entrega();
            if (quantidadeDeLocacoesLocados()==0){
                status = StatusPedido.FECHADO;
            }
        }
    }

    private int quantidadeDeLocacoesLocados(){
        int contador =0;
        for(Locacao locacao:locacoes){
            if(locacao.getStatus()==StatusLocacao.LOCADO){
                contador++;
            }
        }
        return contador;
    }
}
