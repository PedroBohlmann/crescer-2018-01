package br.com.cwi.crescer.oldflix.web;


import br.com.cwi.crescer.oldflix.dominio.*;
import br.com.cwi.crescer.oldflix.service.pedido.BuscaPedidoPorIdService;
import br.com.cwi.crescer.oldflix.service.pedido.DevolveFitaComClienteCpfService;
import br.com.cwi.crescer.oldflix.service.pedido.SalvaPedidoService;
import br.com.cwi.crescer.oldflix.web.model.Request.PedidoDevolveRequest;
import br.com.cwi.crescer.oldflix.web.model.Request.PedidoRequest;
import br.com.cwi.crescer.oldflix.web.model.Response.FitaSemFilmeResponse;
import br.com.cwi.crescer.oldflix.web.model.Response.LocacaoResponse;
import br.com.cwi.crescer.oldflix.web.model.Response.PedidoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/pedido")
@RestController
public class PedidoController {

    @Autowired
    private SalvaPedidoService salvaPedidoService;

    @Autowired
    private BuscaPedidoPorIdService buscaPedidoPorIdService;

    @Autowired
    private DevolveFitaComClienteCpfService devolveFitaComClienteCpfService;

    @PostMapping
    public void criarPedido(@RequestBody PedidoRequest pedidoRequest){
        salvaPedidoService.salvar(pedidoRequest);
    }

    @GetMapping("/{id}")
    public PedidoResponse buscarPedido(@PathVariable("id")Long id){
        return mapearPedidoParaResponse(buscaPedidoPorIdService.buscar(id));
    }

    @PostMapping("/devolve")
    public void devolve(@RequestBody PedidoDevolveRequest pedidoDevolveRequest){
        devolveFitaComClienteCpfService.devolve(pedidoDevolveRequest);
    }

    private PedidoResponse mapearPedidoParaResponse(Pedido pedido){
        List<LocacaoResponse> locacoes = new ArrayList<>();
        for(Locacao locacao:pedido.getLocacoes()){
            FitaSemFilmeResponse fitaNova = FitaSemFilmeResponse.
                    builder()
                    .id(locacao.getFita().getId())
                    .locado(locacao.getFita().isLocado())
                    .build();

            locacoes.add(LocacaoResponse
                    .builder()
                    .id(locacao.getId())
                    .fita(fitaNova)
                    .status(locacao.getStatus())
                    .prazo(locacao.getPrazo())
                    .build());
        }
        return PedidoResponse
                .builder()
                .id(pedido.getId())
                .locacao(locacoes)
                .status(pedido.getStatus())
                .valor(pedido.getValorTotal()).build();
    }
}
