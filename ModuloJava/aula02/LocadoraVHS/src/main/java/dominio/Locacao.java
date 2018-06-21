package dominio;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Locacao {

    private Fita fita;

    private StatusLocacao status;

    private LocalDate prazo;

    public Locacao(Fita fita) {
        this.fita = fita;
        this.status = StatusLocacao.LOCADO;
        this.prazo = LocalDate.now();
        this.prazo = prazo.plusDays(fita.getPrazo());
    }

    public void devolve() {
        this.status = StatusLocacao.DEVOLVIDO;
    }

    public void atualizaPrazo(int dias) {
        prazo = prazo.minusDays(fita.getPrazo());
        prazo = prazo.plusDays(dias);
    }
}
