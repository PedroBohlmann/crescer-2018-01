package br.com.cwi.redesocial.dominio.repository;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import org.springframework.data.repository.Repository;

public interface ICurtidaRepository extends Repository<Curtida, Long> {
    void save(Curtida curtida);

    void deleteByUsuarioAndPost(Usuario usuario,Post post);

    void findByUsuarioAndPost(Usuario usuario,Post post);
}
