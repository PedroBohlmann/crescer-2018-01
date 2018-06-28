package br.com.cwi.redesocial.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {

    private static final String SEQUENCE = "USUARIO_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_USUARIO", nullable = false, precision = 10, unique = true)
    private Long id;

    @Column(name = "NOME_COMPLETO", length = 255,nullable = false)
    private String nome;

    @Column(name = "EMAIL",length = 255,nullable = false)
    private String email;

    @Column(name = "APELIDO",length = 50)
    private String apelido;

    @Column(name = "DATA_DE_NASCIMENTO",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeNascimento;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "IMAGEM_DE_PERFIL",length =512)
    private String imagemUrl;

    @OneToMany(mappedBy = "criador")
    private List<Post> posts;

    @OneToMany(mappedBy = "usuario")
    private List<Curtida> curtidas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

//    @OneToMany(mappedBy = "usuario")
//    private List<Usuario> amigos;
}
