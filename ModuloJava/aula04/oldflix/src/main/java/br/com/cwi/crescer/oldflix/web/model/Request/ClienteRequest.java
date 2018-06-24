package br.com.cwi.crescer.oldflix.web.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ClienteRequest {

    private Long id;

    private String nome;

    private String cpf;
}
