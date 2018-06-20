package models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Locadora {
    public List<Cliente> clientes;
    public List<Filme> filmes;
    public List<Pedido> pedidos;

    private int idPedidos;

    public Locadora() {
        this.idPedidos = 0;
        this.clientes = new ArrayList<>();
        this.filmes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizaPedido(String tituloFilme, String cpfCliente) {

        Cliente clienteProcurado = clientes.stream()
                .filter(p -> p.getCpf().equals(cpfCliente))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("CPF inválido"));

        Filme filme = filmes.stream()
                .filter(p -> p.getTitulo().equals(tituloFilme))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Filme inválido"));

        Fita fita = filme.primeiraFitaNaoLocada();

        Pedido pedido = pedidos.stream()
                .filter(p -> p.getCliente().equals(clienteProcurado))
                .findFirst()
                .orElse(null);

        if (pedido == null) {
            Pedido novo = new Pedido(idPedidos++, clienteProcurado);
            novo.adicionaFita(fita);
            pedidos.add(novo);
        } else {
            pedido.adicionaFita(fita);
        }
    }

    public void realizaPedido(List<String> listaDeTitulos, String cpfCliente) {

        Cliente clienteProcurado = clientes.stream()
                .filter(p -> p.getCpf().equals(cpfCliente))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("CPF inválido"));

        Pedido pedido = pedidos.stream()
                .filter(p -> p.getCliente().equals(clienteProcurado))
                .findFirst()
                .orElse(null);

        if (pedido == null) {
            pedido = new Pedido(idPedidos++, clienteProcurado);
            pedidos.add(pedido);
        }

        for(String titulo : listaDeTitulos){
            Filme filme = filmes.stream()
                    .filter(p -> p.getTitulo().equals(titulo))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Filme inválido"));

            Fita fita = filme.primeiraFitaNaoLocada();
            pedido.adicionaFita(fita);
        }
    }

    public void devolveFita(Fita fita){
        Pedido pedidoProcurado  = pedidos.stream().filter(p->p.getFitas().contains(fita)).findFirst().orElseThrow(()->new RuntimeException());

        pedidoProcurado.removeFita(fita);
    }
}
