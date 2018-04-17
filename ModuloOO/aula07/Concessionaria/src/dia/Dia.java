package dia;

import contratos.Servico;
import produtos.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dia {
    private List<Produto> listaDeProdutosVendidos;
    private List<Servico> listaDeServicoRealizados;

    public Dia(){
        listaDeProdutosVendidos=new ArrayList<>();
        listaDeServicoRealizados=new ArrayList<>();
    }

    public void vendeProduto(Produto produto){
        listaDeProdutosVendidos.add(produto);
    }

    public void realizaServico(Servico servico){
        listaDeServicoRealizados.add(servico);
    }

    public void vendeProdutosEmLote(List<Produto> listaDeProdutosVendidosEmLote){
        listaDeProdutosVendidos.addAll(listaDeProdutosVendidosEmLote);
    }

    public double calcularValorTotalDeEntrada(){
        double valorTotal=0;
        valorTotal+=calcularValorTotalDeEntradaDeProdutos()+calcularValorTotalDeEntradaDeServicos();
        return valorTotal;
    }

    public double calcularValorTotalDeLucro(){
        double valorTotal=0;
        valorTotal+=calcularValorTotalDeLucroDeProdutos()+calcularValorTotalDeLucroDeServicos();
        return valorTotal;
    }

    public double calcularValorTotalDeEntradaDeServicos(){
        int valorTotal=0;
        for(Servico servicoAtual: listaDeServicoRealizados){
            valorTotal+=servicoAtual.calcularValorTotalServico();
        }
        return valorTotal;
    }

    public double calcularValorTotalDeEntradaDeProdutos(){
        int valorTotal=0;
        for(Produto produtoAtual:listaDeProdutosVendidos){
            valorTotal+=produtoAtual.calcularValorTotal();
        }
        return  valorTotal;
    }

    public double calcularValorTotalDeLucroDeServicos(){
        int valorTotal=0;
        for(Servico servicoAtual: listaDeServicoRealizados){
            valorTotal+=servicoAtual.calcularLucroTotal();
        }
        return valorTotal;
    }

    public double calcularValorTotalDeLucroDeProdutos(){
        int valorTotal=0;
        for(Produto produtoAtual:listaDeProdutosVendidos){
            valorTotal+=produtoAtual.calcularLucroTotal();
        }
        return  valorTotal;
    }

    public void ordernarProdutosDeFormaCrescente(){
        Comparator<Produto> comparatorProduto= Comparator.comparing(Produto::calcularValorTotal);
        List<Produto> listaDeProdutosVendidosOrganizado= listaDeProdutosVendidos.stream().sorted(comparatorProduto).collect(Collectors.toList());
        listaDeProdutosVendidos=listaDeProdutosVendidosOrganizado;
    }


    public void ordernarProdutosDeFormaDeCrescente(){
        Comparator<Produto> comparatorProduto= Comparator.comparing(Produto::calcularValorTotal);
        List<Produto> listaDeProdutosVendidosOrganizado= listaDeProdutosVendidos.stream().sorted(comparatorProduto.reversed()).collect(Collectors.toList());
        listaDeProdutosVendidos=listaDeProdutosVendidosOrganizado;
    }

    public void removeProduto(Produto produto){
        listaDeProdutosVendidos.remove(produto);
    }

    public void removeServico(Servico servico){
        listaDeServicoRealizados.remove(servico);
    }

    public Produto getProdutoNaPosicao(int posicao){
        if(posicao<listaDeProdutosVendidos.size()) {
            return listaDeProdutosVendidos.get(posicao);
        }
        return null;
    }
}
