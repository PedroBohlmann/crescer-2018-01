package br.com.cwi.crescer.oldflix.dominio.repository;

import br.com.cwi.crescer.oldflix.dominio.Filme;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface IFilmeRepository extends Repository<Filme,Long> {

    List<Filme> findAll();

    Optional<Filme> findById(Long id);

    Optional<Filme> findFilmeByTitulo(String titulo);

    void save(Filme filme);

    void delete(Filme filme);
}
