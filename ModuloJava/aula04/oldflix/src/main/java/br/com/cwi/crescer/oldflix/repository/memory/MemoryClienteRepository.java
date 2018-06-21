package br.com.cwi.crescer.oldflix.repository.memory;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.repository.IClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryClienteRepository implements IClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clientes.stream().filter(c->c.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Cliente cliente) {
        Optional<Cliente> clienteOptional = this.findById(cliente.getId());
        if(clienteOptional.isPresent()){
            Cliente clienteCarregado = clienteOptional.get();
            clienteCarregado.setNome(cliente.getNome());

        }else{
            clientes.add(cliente);
        }
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }
}
