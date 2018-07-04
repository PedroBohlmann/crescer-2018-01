package br.com.cwi.redesocial.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UsuarioRequest {

    private Long id;

    private String nome;

    private String email;

    private String apelido;

    private LocalDate dataDeNascimento;

    private String senha;

    private String imagemUrl;
}
