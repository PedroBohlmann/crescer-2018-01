package br.com.cwi.crescer.oldflix.dominio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FILME")
public class Filme {

    private static final String SEQUENCE = "FILME_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_FILME",nullable = false,precision = 10,unique = true)
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "VALOR")
    private double valor;

    @Column(name = "PRAZO")
    private int prazoEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA")
    private Categoria categoria;

    @OneToMany(mappedBy = "filme")
//    @JsonManagedReference
    private List<Fita> fitas;

    public Filme(String titulo, Categoria categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.valor = categoria.getValor();
        this.prazoEntrega = categoria.getPrazo();
        this.fitas = new ArrayList<>();
    }

    public Filme(){ }

    public void atualizaDados(Filme filme){
        this.titulo = filme.titulo;
        this.valor = filme.valor;
        this.prazoEntrega = filme.getPrazoEntrega();
        this.categoria = filme.getCategoria();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(id, filme.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Fita primeiraFitaNaoLocada(){
        return fitas.stream().filter(p->!p.isLocado()).findFirst().orElseThrow(() -> new RuntimeException("Esse filme não possui fitas validas"));
    }

    public void adicionaFita(Fita fita){
        fitas.add(fita);
        fita.setFilme(this);
    }
}
