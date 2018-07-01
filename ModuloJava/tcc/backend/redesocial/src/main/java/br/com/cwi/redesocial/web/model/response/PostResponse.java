package br.com.cwi.redesocial.web.model.response;

import lombok.Data;

import java.util.List;

@Data
public class PostResponse {

    private Long id;

    private String texto;

    private String nomeCriador;

    private Long idCriador;

    private List<CurtidaResponse> curtidas;

}
