package br.com.cwi.crescer.oldflix.service.cliente;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuscarClientePorCpfService {
    @Autowired
    private IClienteRepository repository;

    public Cliente buscar(String cpf){
        return repository
                .findByCpf(cpf)
                .orElseThrow(()->new IllegalArgumentException("Sem Cliente com esse cpf ="+cpf));
    }

}
