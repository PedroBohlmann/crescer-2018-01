package br.com.cwi.redesocial.dominio.repository;

import br.com.cwi.redesocial.dominio.Post;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface IPostRepository extends Repository<Post,Long> {
    void save(Post post);

    Optional<Post> findById(Long id);
}
