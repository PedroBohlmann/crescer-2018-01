package dominio;

import lombok.Getter;

@Getter
public class Locacao {

    private Fita fita;

    private StatusLocacao status;

    private int prazo;

    public Locacao(Fita fita, int prazo) {
        this.fita = fita;
        this.status = StatusLocacao.LOCADO;
        this.prazo = prazo;
    }

    public void devolve(){
        this.status = StatusLocacao.DEVOLVIDO;
    }
}
