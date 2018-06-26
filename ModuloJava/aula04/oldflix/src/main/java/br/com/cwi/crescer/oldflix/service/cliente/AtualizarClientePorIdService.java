package br.com.cwi.crescer.oldflix.service.cliente;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class AtualizarClientePorIdService {

    @Autowired
    private IClienteRepository repository;

    @Autowired
    private BuscarClientePorIdService buscarClientePorIdService;

    public void atualizar(Long id, Cliente cliente){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id invalido");
        }
        Cliente clienteCarregado = buscarClientePorIdService.buscar(id);

        clienteCarregado.atualizar(cliente);

        repository.save(clienteCarregado);
    }
}
