package br.com.cwi.redesocial.dominio.repository;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ICurtidaRepository extends Repository<Curtida, Long> {
    void save(Curtida curtida);

    void delete(Curtida curtida);

    Optional<Curtida> findFirstByUsuarioAndPost(Usuario usuario, Post post);
}
