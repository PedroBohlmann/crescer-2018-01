package br.com.cwi.crescer.oldflix.service.pedido;

import br.com.cwi.crescer.oldflix.dominio.*;
import br.com.cwi.crescer.oldflix.dominio.repository.IPedidoRepository;
import br.com.cwi.crescer.oldflix.service.cliente.BuscarClientePorCpfService;
import br.com.cwi.crescer.oldflix.service.filme.BuscarFilmePeloTituloService;
import br.com.cwi.crescer.oldflix.web.model.Request.PedidoRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SalvaPedidoServiceTest {

    @Mock
    private IPedidoRepository repository;

    @Mock
    private BuscarClientePorCpfService buscarClientePorCpfService;

    @Mock
    private BuscarFilmePeloTituloService buscarFilmePeloTituloService;

    @InjectMocks
    private SalvaPedidoService salvaPedidoService;

    @Captor
    private ArgumentCaptor<Pedido> pedidoArgumentCaptor;

    @Test
    public void testaSalvandoPedido(){
        String cpf = "11111111111";
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setPedidos(new ArrayList<Pedido>());

        String titulo = "Rei leao";
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setCategoria(Categoria.DOURADA);

        Long idFita = 1L;
        Fita fita = new Fita();
        fita.setId(idFita);
        filme.setFitas(new ArrayList<Fita>());

        filme.adicionaFita(fita);

        // mock
        Mockito.when(buscarClientePorCpfService.buscar(cpf)).thenReturn(cliente);
        Mockito.when(buscarFilmePeloTituloService.buscarFilme(titulo)).thenReturn(filme);

        PedidoRequest pedidoRequest =new PedidoRequest();
        List<String> titulos = new ArrayList<>();
        titulos.add(titulo);

        pedidoRequest.setFilmes(titulos);
        pedidoRequest.setCpf(cpf);

        salvaPedidoService.salvar(pedidoRequest);

        Mockito.verify(repository,Mockito.times(1)).save(pedidoArgumentCaptor.capture());

        Pedido pedidoCapturado = pedidoArgumentCaptor.getValue();

        Assert.assertEquals(StatusPedido.PENDENTE,pedidoCapturado.getStatus());
        Assert.assertEquals(1,pedidoCapturado.getLocacoes().size());
    }
}
