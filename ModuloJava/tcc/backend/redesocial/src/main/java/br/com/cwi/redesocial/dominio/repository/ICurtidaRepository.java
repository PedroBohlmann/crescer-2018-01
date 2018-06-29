package br.com.cwi.redesocial.dominio.repository;

import br.com.cwi.redesocial.dominio.Curtida;
import org.springframework.data.repository.Repository;

public interface ICurtidaRepository extends Repository<Curtida, Long> {
    void save(Curtida curtida);
}
