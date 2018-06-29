package br.com.cwi.redesocial.web.model.request;

import lombok.*;

@Data
public class ComentarioRequest {

    private Long idPost;

    private String texto;
}
