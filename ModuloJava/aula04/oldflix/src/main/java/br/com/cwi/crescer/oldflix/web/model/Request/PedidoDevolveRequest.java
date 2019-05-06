package br.com.cwi.crescer.oldflix.web.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoDevolveRequest {
    private String cpf;

    private Long idFita;
}
