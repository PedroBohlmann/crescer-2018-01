package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BuscarPostPorIdService {
    @Autowired
    private IPostRepository postRepository;

    public Post buscar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id nulo");
        }

        Optional<Post> post = postRepository.findById(id);

        return post.orElse(null);
    }
}
