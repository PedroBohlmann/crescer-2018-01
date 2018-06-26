package br.com.cwi.crescer.oldflix.service.pedido;

import br.com.cwi.crescer.oldflix.dominio.*;
import br.com.cwi.crescer.oldflix.dominio.repository.IPedidoRepository;
import br.com.cwi.crescer.oldflix.service.cliente.BuscarClientePorCpfService;
import br.com.cwi.crescer.oldflix.service.fita.BuscarFitaPorIdService;
import br.com.cwi.crescer.oldflix.web.model.Request.PedidoDevolveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DevolveFitaComClienteCpfService {
    @Autowired
    private IPedidoRepository repository;

    @Autowired
    private BuscarClientePorCpfService buscarClientePorCpfService;

    @Autowired
    private BuscarFitaPorIdService buscarFitaPorIdService;

    public void devolve(PedidoDevolveRequest pedidoDevolveRequest){
        Cliente cliente = buscarClientePorCpfService.buscar(pedidoDevolveRequest.getCpf());

        Pedido pedidoProcurado = null;

        for(Pedido pedidoAtual:cliente.getPedidos()){
            Locacao locacao = pedidoAtual
                    .getLocacoes()
                    .stream()
                    .filter(p->p.getFita().getId()==pedidoDevolveRequest.getIdFita())
                    .findFirst().orElse(null);
            if(locacao!=null&&pedidoAtual.getStatus()==StatusPedido.PENDENTE){
                pedidoProcurado = pedidoAtual;
                break;
            }
        }

        if(pedidoProcurado!=null){
            Fita fitaCarregada = buscarFitaPorIdService.buscar(pedidoDevolveRequest.getIdFita());
            pedidoProcurado.devolveFita(fitaCarregada);
            repository.save(pedidoProcurado);
        }
    }
}
