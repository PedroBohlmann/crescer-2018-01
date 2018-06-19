package models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Locadora {
    public List<Cliente> clientes;
    public List<Filme> filmes;
    public List<Pedido> pedidos;

    private int idCliente = 0;
    private int idFilme = 0;
    private int idPedidos = 0;


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

        if(pedido == null){
            Pedido novo = Pedido.builder().idPedido(idPedidos++).cliente(clienteProcurado).fita(fita).build();
            pedidos.add(novo);
        }
        else{
            pedido.adicionaFita(fita);
        }
    }
}
