package br.com.cwi.crescer.oldflix.web.model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class FitaSemFilmeResponse {

    private Long id;

    private boolean locado;
}
