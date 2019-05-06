package br.com.cwi.crescer.oldflix.service.cliente;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.repository.IClienteRepository;
import br.com.cwi.crescer.oldflix.exception.ClienteNaoCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class BuscarClientePorIdService {

    @Autowired
    private IClienteRepository repository;

    public Cliente buscar(Long id){

        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id invalido");
        }

        return repository
                .findById(id)
                .orElseThrow(()->new ClienteNaoCadastrado(id));
    }
}
