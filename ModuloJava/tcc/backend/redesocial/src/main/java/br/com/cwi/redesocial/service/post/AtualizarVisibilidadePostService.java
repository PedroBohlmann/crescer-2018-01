package br.com.cwi.redesocial.service.post;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.VisibilidadePost;
import br.com.cwi.redesocial.dominio.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AtualizarVisibilidadePostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private BuscarPostPorIdService buscarPostPorIdService;

    public void atualizar(Long id, VisibilidadePost visibilidade){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("Id post nulo");
        }
        if(Objects.isNull(visibilidade)){
            throw new IllegalArgumentException("Visibilidade nulo");
        }

        Post post = buscarPostPorIdService.buscar(id);

        if(Objects.isNull(post)){
            throw new IllegalArgumentException("Sem Post com esse id");
        }

        post.atualizarVisibilidade(visibilidade);

        postRepository.save(post);
    }
}
