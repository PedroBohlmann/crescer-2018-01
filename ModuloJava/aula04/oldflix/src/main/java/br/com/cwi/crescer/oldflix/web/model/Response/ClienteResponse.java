package br.com.cwi.crescer.oldflix.web.model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class ClienteResponse {

    private Long id;

    private String nome;

    private String cpf;

    private List<PedidoResponse> pedidos;
}
