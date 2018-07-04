package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BuscarPostPublicoPorIdService {

    @Autowired
    private IPostRepository postRepository;

    public Post buscar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("id nulo");
        }

        Optional<Post> post = postRepository.findByIdAndVisibilidade(id,VisibilidadePost.PUBLICO);

        return post.orElse(null);
    }
}
