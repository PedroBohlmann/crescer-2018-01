package br.com.cwi.crescer.oldflix.web;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.Locacao;
import br.com.cwi.crescer.oldflix.dominio.Pedido;
import br.com.cwi.crescer.oldflix.service.cliente.*;
import br.com.cwi.crescer.oldflix.web.model.Request.ClienteRequest;
import br.com.cwi.crescer.oldflix.web.model.Response.ClienteResponse;
import br.com.cwi.crescer.oldflix.web.model.Response.FitaSemFilmeResponse;
import br.com.cwi.crescer.oldflix.web.model.Response.LocacaoResponse;
import br.com.cwi.crescer.oldflix.web.model.Response.PedidoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private BuscarClientePorIdService buscarClientePorIdService;

    @Autowired
    private ListarClientesService listarClientesService;

    @Autowired
    private SalvarClienteService salvarClienteService;

    @Autowired
    private AtualizarClientePorIdService atualizarClientePorIdService;

    @Autowired
    private DeletarClientePorIdService deletarClientePorIdService;

    @GetMapping()
    public List<ClienteResponse> listar() {
        List<Cliente> clientes = listarClientesService.listar();
        List<ClienteResponse> response = new ArrayList<>();
        for(Cliente cliente:clientes){
            response.add(mapearClienteParaResponse(cliente));
        }
        return response;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void incluirCliente(@RequestBody ClienteRequest clienteDto){
        Cliente cliente = mapearClienteRequestParaCliente(clienteDto);
        salvarClienteService.criar(cliente);
    }

    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable("id")Long id){
        return mapearClienteParaResponse(buscarClientePorIdService.buscar(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse atualizarCliente(@PathVariable("id")long id, @RequestBody ClienteRequest clienteDto){
        Cliente cliente = mapearClienteRequestParaCliente(clienteDto);
        atualizarClientePorIdService.atualizar(id,cliente);

        return mapearClienteParaResponse(buscarClientePorIdService.buscar(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable("id")Long id){
        deletarClientePorIdService.deletar(id);
    }

    private Cliente mapearClienteRequestParaCliente(ClienteRequest clienteRequest){
        return new Cliente(clienteRequest.getNome(),clienteRequest.getCpf());
    }

    private ClienteResponse mapearClienteParaResponse(Cliente cliente){
        List<PedidoResponse> pedidos = new ArrayList<>();
        for(Pedido pedido:cliente.getPedidos()){
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
            pedidos.add(PedidoResponse
                    .builder()
                    .id(pedido.getId())
                    .valor(pedido.getValorTotal())
                    .status(pedido.getStatus())
                    .locacao(locacoes)
                    .build());
        }
        return ClienteResponse
                .builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .pedidos(pedidos)
                .build();
    }

}
