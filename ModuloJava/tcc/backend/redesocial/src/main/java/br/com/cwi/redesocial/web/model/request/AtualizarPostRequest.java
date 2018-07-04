package br.com.cwi.redesocial.web.model.request;

import br.com.cwi.redesocial.dominio.VisibilidadePost;
import lombok.Data;

@Data
public class AtualizarPostRequest {

    private VisibilidadePost visibilidade;
}
