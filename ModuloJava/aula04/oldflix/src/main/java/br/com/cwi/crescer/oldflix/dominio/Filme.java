package br.com.cwi.crescer.oldflix.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Filme {

    private Long id;
    private String titulo;
    private double valor;
    private int prazoEntrega;
    private Categoria categoria;

    public Filme(Long id,String titulo, Categoria categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.valor = categoria.getValor();
        this.prazoEntrega = categoria.getPrazo();
        this.id = id;
    }

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
}
