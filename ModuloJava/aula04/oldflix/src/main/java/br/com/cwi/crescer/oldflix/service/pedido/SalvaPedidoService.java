package br.com.cwi.crescer.oldflix.service.pedido;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.Fita;
import br.com.cwi.crescer.oldflix.dominio.Pedido;
import br.com.cwi.crescer.oldflix.dominio.StatusPedido;
import br.com.cwi.crescer.oldflix.dominio.repository.IPedidoRepository;
import br.com.cwi.crescer.oldflix.service.cliente.BuscarClientePorCpfService;
import br.com.cwi.crescer.oldflix.service.filme.BuscarFilmePeloTituloService;
import br.com.cwi.crescer.oldflix.web.model.Request.PedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalvaPedidoService {

    @Autowired
    private IPedidoRepository repository;

    @Autowired
    private BuscarClientePorCpfService buscarClientePorCpfService;

    @Autowired
    private BuscarFilmePeloTituloService buscarFilmePeloTituloService;

    public void salvar(PedidoRequest pedidoRequest){
        Cliente cliente = buscarClientePorCpfService.buscar(pedidoRequest.getCpf());
        Pedido pedidoExistente = cliente.getPedidos()
                .stream()
                .filter(p->p.getStatus()==StatusPedido.PENDENTE)
                .findFirst()
                .orElse(null);

        if(pedidoExistente==null) {

            List<Fita> fitas = new ArrayList<>();
            for (String titulo : pedidoRequest.getFilmes()) {
                fitas.add(buscarFilmePeloTituloService.buscarFilme(titulo).primeiraFitaNaoLocada());
            }

            Pedido pedido = new Pedido(cliente);
            pedido.adicionarFitas(fitas);

            repository.save(pedido);
        }
    }
}
