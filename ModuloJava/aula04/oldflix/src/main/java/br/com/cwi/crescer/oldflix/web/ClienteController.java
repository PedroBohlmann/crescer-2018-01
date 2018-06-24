package br.com.cwi.crescer.oldflix.web;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.service.cliente.*;
import br.com.cwi.crescer.oldflix.web.model.Request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Cliente> listar() {
        return listarClientesService.listar();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void incluirCliente(@RequestBody ClienteRequest clienteDto){
        Cliente cliente = mapearClienteRequestParaCliente(clienteDto);
        salvarClienteService.criar(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable("id")Long id){
        return buscarClientePorIdService.buscar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizarCliente(@PathVariable("id")long id, @RequestBody ClienteRequest clienteDto){
        Cliente cliente = mapearClienteRequestParaCliente(clienteDto);
        atualizarClientePorIdService.atualizar(id,cliente);

        return buscarClientePorIdService.buscar(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable("id")Long id){
        deletarClientePorIdService.deletar(id);
    }

    private Cliente mapearClienteRequestParaCliente(ClienteRequest clienteRequest){
        return new Cliente(clienteRequest.getNome(),clienteRequest.getCpf());
    }

}
