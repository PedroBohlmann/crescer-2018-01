package br.com.cwi.redesocial.web.model.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioResponse {

    private Long id;

    private String nome;

    private String email;

    private String apelido;

    private LocalDate dataDeNascimento;

    private String imagemUrl;

//    private List<PostResponse> posts;

}
