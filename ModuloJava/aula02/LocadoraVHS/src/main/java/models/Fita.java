package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
public class Fita {
    private Filme filme;

    private int idFita;

    private boolean locado;

    public Fita() {
        this.locado = false;
    }

    public Fita(int idFita) {
        this.idFita = idFita;
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

    public String getTituloFilme(){
        return filme.getTitulo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fita fita = (Fita) o;
        return idFita == fita.idFita;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFita);
    }
}
