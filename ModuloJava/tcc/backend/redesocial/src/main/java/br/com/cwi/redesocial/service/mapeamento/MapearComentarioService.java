package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Comentario;
import br.com.cwi.redesocial.web.model.request.ComentarioRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MapearComentarioService {

    public Comentario mapearComentarioRequestParaComentario(ComentarioRequest request){
        if(Objects.isNull(request)){
            throw new IllegalArgumentException("Request invalido");
        }
        if(Objects.isNull(request.getIdPost())){
            throw new IllegalArgumentException("Post nulo");
        }
        if(Objects.isNull(request.getTexto())||request.getTexto().length()==0){
            throw new IllegalArgumentException("Texto nulo ou vazio");
        }
        Comentario comentarioMapeado = new Comentario();
        comentarioMapeado.setTexto(request.getTexto());

        return comentarioMapeado;
    }
}
