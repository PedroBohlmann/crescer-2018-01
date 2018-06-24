package br.com.cwi.crescer.oldflix.web.model.Response;

import br.com.cwi.crescer.oldflix.dominio.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class FilmeResponse {

    private Long id;

    private String titulo;

    private double valor;

    private int prazoEntrega;

    private Categoria categoria;

    private List<FitaSemFilmeResponse> fitas;
}
