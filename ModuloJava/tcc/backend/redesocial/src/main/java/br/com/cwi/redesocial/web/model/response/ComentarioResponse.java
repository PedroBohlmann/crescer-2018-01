package br.com.cwi.redesocial.web.model.response;

import lombok.Data;

@Data
public class ComentarioResponse {

    private Long id;

    private String texto;

    private Long idCriador;

    private String nomeCriador;
}
