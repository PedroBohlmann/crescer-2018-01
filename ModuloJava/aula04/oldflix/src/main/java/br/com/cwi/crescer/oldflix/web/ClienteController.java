package br.com.cwi.crescer.oldflix.web;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.repository.IClienteRepository;
import br.com.cwi.crescer.oldflix.exception.ClienteNaoCadastrado;
import br.com.cwi.crescer.oldflix.service.cliente.BuscarClientePorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private IClienteRepository repository;

    @Autowired
    private BuscarClientePorIdService service;


    @GetMapping()
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void incluirCliente(@RequestBody Cliente cliente){
        repository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable("id")Long id){
        return repository
                .findById(id)
                .orElseThrow(()->new ClienteNaoCadastrado(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizarCliente(@PathVariable("id")long id, @RequestBody Cliente cliente){
        repository.save(cliente);

        return repository
                .findById(id)
                .orElseThrow(()->new ClienteNaoCadastrado(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable("id")Long id){
        Cliente cliente =  repository
                            .findById(id)
                            .orElseThrow(()->new ClienteNaoCadastrado(id));

        repository.delete(cliente);
    }
}
