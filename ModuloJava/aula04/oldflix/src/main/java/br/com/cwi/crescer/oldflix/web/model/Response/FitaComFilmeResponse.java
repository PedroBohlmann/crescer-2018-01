package br.com.cwi.crescer.oldflix.web.model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class FitaComFilmeResponse {
    private Long id;

    private FilmeSemFitasResponse filme;

    private boolean locado;
}
