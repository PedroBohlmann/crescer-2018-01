package br.com.cwi.redesocial.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CURTIDA")
public class Curtida {

    private static final String SEQUENCE = "CURTIDA_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_CURTIDA", nullable = false, precision = 10, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO",nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_POST", nullable = false)
    private Post post;
}
