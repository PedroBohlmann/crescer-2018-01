package br.com.cwi.crescer.oldflix.dominio;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Fita {

    private Long idFilme;

    private Long id;

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
}
