package br.com.cwi.crescer.oldflix.web.model.Response;

import br.com.cwi.crescer.oldflix.dominio.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class FilmeSemFitasResponse {
    private Long id;

    private String titulo;

    private double valor;

    private int prazoEntrega;

    private Categoria categoria;
}
