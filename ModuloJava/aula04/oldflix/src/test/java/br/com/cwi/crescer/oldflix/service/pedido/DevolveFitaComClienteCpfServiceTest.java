package br.com.cwi.crescer.oldflix.service.pedido;

import br.com.cwi.crescer.oldflix.dominio.*;
import br.com.cwi.crescer.oldflix.dominio.repository.IPedidoRepository;
import br.com.cwi.crescer.oldflix.service.cliente.BuscarClientePorCpfService;
import br.com.cwi.crescer.oldflix.service.fita.BuscarFitaPorIdService;
import br.com.cwi.crescer.oldflix.web.model.Request.PedidoDevolveRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class DevolveFitaComClienteCpfServiceTest {

    @Mock
    private IPedidoRepository repository;

    @Mock
    private BuscarClientePorCpfService buscarClientePorCpfService;

    @Mock
    private BuscarFitaPorIdService buscarFitaPorIdService;

    @InjectMocks
    private DevolveFitaComClienteCpfService devolveFitaComClienteCpfService;


    @Captor
    private ArgumentCaptor<Pedido> captadorPedido;

    @Test
    public void testaSePedidoFecha(){
        //Cenario
        String cpf = "11111111111";
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setPedidos(new ArrayList<Pedido>());

        Filme filme = new Filme();
        filme.setCategoria(Categoria.DOURADA);

        Long idFita = 1L;
        Fita fita = new Fita();
        fita.setId(idFita);
        filme.setFitas(new ArrayList<Fita>());

        filme.adicionaFita(fita);

        Pedido pedido =new Pedido();
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.ATIVO);
        pedido.setLocacoes(new ArrayList<Locacao>());
        pedido.adicionaFita(fita);

        cliente.getPedidos().add(pedido);

        PedidoDevolveRequest pedidoDevolveRequest =new PedidoDevolveRequest(cpf,idFita);

        //mock
        Mockito.when(buscarClientePorCpfService.buscar(cpf)).thenReturn(cliente);
        Mockito.when(buscarFitaPorIdService.buscar(idFita)).thenReturn(fita);

        //execucao
        devolveFitaComClienteCpfService.devolve(pedidoDevolveRequest);

        Mockito.verify(repository,Mockito.times(1)).save(captadorPedido.capture());

        Pedido pedidoCapturado = captadorPedido.getValue();

        Assert.assertEquals(StatusPedido.FECHADO,pedidoCapturado.getStatus());
    }

}
