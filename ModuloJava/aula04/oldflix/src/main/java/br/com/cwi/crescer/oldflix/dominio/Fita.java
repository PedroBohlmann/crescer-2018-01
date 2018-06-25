package br.com.cwi.crescer.oldflix.dominio;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FITA")
public class Fita {

    private static final String SEQUENCE = "FITA_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_FITA",nullable = false,precision = 10,unique = true)
    private Long id;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "ID_FILME",nullable = false)
    private Filme filme;

    @Column(name = "LOCADO", nullable = false)
    private boolean locado;

    public Fita() {
        this.locado = false;
    }

    public Fita(Long idFita) {
        this.id = idFita;
        this.locado = false;
    }

    public boolean isLocado() {
        return locado;
    }

    public void loca() {
        this.locado = true;
    }

    public void entrega() {
        this.locado = false;
    }

    public int getPrazo() {
        return filme.getPrazoEntrega();
    }

    public double getValor() {
        return filme.getValor();
    }

    public Categoria getCategoria(){
        return filme.getCategoria();
    }

    public void atualiza(Fita fita){
        this.locado = fita.isLocado();
    }
}
