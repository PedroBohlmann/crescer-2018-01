package br.com.cwi.crescer.oldflix.dominio.repository;

import br.com.cwi.crescer.oldflix.dominio.Fita;

import java.util.List;
import java.util.Optional;

public interface IFitaRepository {

    List<Fita> findAll();

    Optional<Fita> findById(Long id);

    void save(Fita fita);

    void delete(Fita fita);
}
