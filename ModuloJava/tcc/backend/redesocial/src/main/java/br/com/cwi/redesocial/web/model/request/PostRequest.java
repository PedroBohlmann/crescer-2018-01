package br.com.cwi.redesocial.web.model.request;

import br.com.cwi.redesocial.dominio.VisibilidadePost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    public String texto;

    private VisibilidadePost visibilidade;
}
