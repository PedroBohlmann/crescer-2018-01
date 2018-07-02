package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BuscarPostsPublicosDosAmigosService {

    @Autowired
    private IPostRepository postRepository;

    public List<Post> buscar(List<Usuario> amigos){
        if(Objects.isNull(amigos)){
            throw new IllegalArgumentException("Lista de amigos nula");
        }

        return postRepository.findByCriadorInAndVisibilidade(amigos,VisibilidadePost.PUBLICO);
    }
}