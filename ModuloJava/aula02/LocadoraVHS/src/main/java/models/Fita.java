package models;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Fita {
    private Filme filme;
    private int idFita;

    private boolean locado;

    public void loca(){
        this.locado = true;
    }

    public void entrega(){
        this.locado = false;
    }

    public int prazo(){
        return filme.getPrazoEntrega();
    }
}
