package br.com.cwi.crescer.oldflix.dominio.repository;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository extends Repository<Cliente,Long> {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    void save(Cliente cliente);

    void delete(Cliente cliente);

    Optional<Cliente> findByCpf(String cpf);
}
