package br.com.cwi.redesocial.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "POST")
public class Post {

    private static final String SEQUENCE = "POST_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_POST", nullable = false, precision = 10, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO",nullable = false)
    private Usuario criador;

    @Column(name = "TEXTO",nullable = false)
    private String texto;

    @OneToMany(mappedBy = "post")
    private List<Curtida> curtidas;

    @OneToMany(mappedBy = "post")
    private List<Comentario> comentarios;
}
