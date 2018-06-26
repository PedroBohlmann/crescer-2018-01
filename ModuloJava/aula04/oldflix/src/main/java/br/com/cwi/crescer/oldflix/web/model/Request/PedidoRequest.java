package br.com.cwi.crescer.oldflix.web.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoRequest {

    private String cpf;

    private List<String> filmes;
}
