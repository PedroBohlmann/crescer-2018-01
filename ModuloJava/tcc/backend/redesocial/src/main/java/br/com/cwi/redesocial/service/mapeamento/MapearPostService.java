package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.web.model.request.PostRequest;
import br.com.cwi.redesocial.web.model.response.CurtidaResponse;
import br.com.cwi.redesocial.web.model.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MapearPostService {

    @Autowired
    private MapearCurtidaService mapearCurtidaService;

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

    public PostResponse mapearPostParaResponse(Post post){
        if(Objects.isNull(post)){
            throw new IllegalArgumentException("Sem Post");
        }
        PostResponse response = new PostResponse();
        response.setId(post.getId());
        response.setTexto(post.getTexto());

        Usuario usuarioCriador = post.getCriador();

        if(Objects.isNull(usuarioCriador)){
            throw new IllegalArgumentException("Post sem usuario criador");
        }

        response.setIdCriador(usuarioCriador.getId());
        response.setNomeCriador(usuarioCriador.getNome());

        List<Curtida> curtidas = post.getCurtidas();

        if(Objects.isNull(curtidas)){
            throw new IllegalArgumentException("Post sem curtidas");
        }

        List<CurtidaResponse> curtidaResponses = new ArrayList<>();


        for(Curtida curtida : curtidas){
            curtidaResponses.add(mapearCurtidaService.mapearCurtidaParaResponse(curtida));
        }

        response.setCurtidas(curtidaResponses);

        return response;
    }
}
