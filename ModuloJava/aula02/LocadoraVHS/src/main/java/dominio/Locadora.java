package dominio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Locadora {
    private List<Cliente> clientes;
    private List<Filme> filmes;
    private List<Pedido> pedidos;

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

        List<Fita> fitas = new ArrayList<>();

        for (String titulo : listaDeTitulos) {
            Filme filme = filmes.stream()
                    .filter(p -> p.getTitulo().equals(titulo))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Filme inválido"));

            Fita fita = filme.primeiraFitaNaoLocada();
            fitas.add(fita);
        }

        pedido.adicionarFitas(fitas);

    }

    public void devolveFita(Fita fita, Cliente cliente) {
        Pedido pedidoProcurado = (
                pedidos.stream()
                        .filter(p -> p.getCliente().equals(cliente) && p.getStatus()==StatusPedido.PENDENTE)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Essa fita não esta em algum pedido")));

        pedidoProcurado.devolveFita(fita);
    }
}
