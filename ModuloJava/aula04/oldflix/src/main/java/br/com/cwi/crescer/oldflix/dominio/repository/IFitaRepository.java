package br.com.cwi.crescer.oldflix.dominio.repository;

import br.com.cwi.crescer.oldflix.dominio.Fita;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface IFitaRepository extends Repository<Fita,Long> {

    List<Fita> findAll();

    Optional<Fita> findById(Long id);

    void save(Fita fita);

    void delete(Fita fita);
}
