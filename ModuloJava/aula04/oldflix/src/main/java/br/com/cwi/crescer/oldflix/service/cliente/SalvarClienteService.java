package br.com.cwi.crescer.oldflix.service.cliente;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalvarClienteService {

    @Autowired
    private IClienteRepository repository;

    public void criar(Cliente cliente){
        repository.save(cliente);
    }
}
