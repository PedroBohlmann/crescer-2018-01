package br.com.cwi.crescer.oldflix.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "LOCACAO")
public class Locacao {

    private static final String SEQUENCE = "LOCACAO_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_LOCACAO", nullable = false, precision = 10, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_FITA",nullable = false)
    private Fita fita;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_PEDIDO",nullable = false)
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_LOCACAO")
    private StatusLocacao status;

    @Column(name = "PRAZO")
    private Date prazo;

    public Locacao(Fita fita,Pedido pedido) {
        this.fita = fita;
        this.pedido = pedido;
        this.status = StatusLocacao.LOCADO;
        this.prazo = Date.valueOf(LocalDate.now().plusDays(fita.getPrazo()));
    }

    public void devolve() {
        this.status = StatusLocacao.DEVOLVIDO;
    }

    public void atualizaPrazo(int dias) {
        LocalDate prazoTemporario = prazo.toLocalDate();

        prazoTemporario = prazoTemporario.minusDays(fita.getPrazo());
        prazoTemporario = prazoTemporario.plusDays(dias);

        prazo = Date.valueOf(prazoTemporario);
    }
}
