package br.com.cwi.crescer.oldflix.web.model.Response;

import br.com.cwi.crescer.oldflix.dominio.StatusLocacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Getter
public class LocacaoResponse {

    private Long id;

    private FitaSemFilmeResponse fita;

    private StatusLocacao status;

    private Date prazo;
}
