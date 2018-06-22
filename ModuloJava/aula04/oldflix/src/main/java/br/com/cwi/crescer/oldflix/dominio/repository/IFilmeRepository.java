package br.com.cwi.crescer.oldflix.dominio.repository;

import br.com.cwi.crescer.oldflix.dominio.Filme;

import java.util.List;
import java.util.Optional;

public interface IFilmeRepository {

    List<Filme> findAll();

    Optional<Filme> findById(Long id);

    void save(Filme filme);

    void delete(Filme filme);
}
