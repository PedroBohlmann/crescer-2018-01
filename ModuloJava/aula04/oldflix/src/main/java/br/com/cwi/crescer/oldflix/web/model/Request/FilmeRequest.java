package br.com.cwi.crescer.oldflix.web.model.Request;

import br.com.cwi.crescer.oldflix.dominio.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FilmeRequest {

    private String titulo;

    private Categoria categoria;

    public FilmeRequest(String titulo, Categoria categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
    }
}

