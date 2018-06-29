package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.web.model.request.PostRequest;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class MapearPostService {

    public Post mapearPostRequestParaPost(PostRequest request){
        if(Objects.isNull(request)){
            throw new IllegalArgumentException("Request nulo");
        }

        if(Objects.isNull(request.getTexto())||request.getTexto().length()==0){
            throw new IllegalArgumentException("Texto vazio ou nulo");
        }
        if(Objects.isNull(request.getVisibilidade())){
            throw new IllegalArgumentException("Visibilidade invalida");
        }

        Post postMapeado = new Post();
        postMapeado.setTexto(request.getTexto());
        postMapeado.setVisibilidade(request.getVisibilidade());

        return postMapeado;
    }
}
