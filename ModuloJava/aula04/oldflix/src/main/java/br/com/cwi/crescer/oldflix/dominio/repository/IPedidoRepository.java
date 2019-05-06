package br.com.cwi.crescer.oldflix.dominio.repository;

import br.com.cwi.crescer.oldflix.dominio.Pedido;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface IPedidoRepository extends Repository<Pedido,Long> {

    List<Pedido> findAll();

    Optional<Pedido> findById(Long id);

    void save(Pedido pedido);

    void delete(Pedido pedido);

}
