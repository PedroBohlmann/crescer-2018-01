package br.com.cwi.crescer.oldflix.web.model.Response;

import br.com.cwi.crescer.oldflix.dominio.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class PedidoResponse {
    private Long id;

    private double valor;

    private StatusPedido status;

    private List<LocacaoResponse> locacao;
}
