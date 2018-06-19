package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Getter
@Builder
public class Filme {

    private String titulo;
    private double valor;
    private int prazoEntrega;
    private int idFilme;

    @Singular
    private List<Fita> fitas;

    public Fita primeiraFitaNaoLocada(){
        return fitas.stream().filter(p->!p.isLocado()).findFirst().orElseThrow(() -> new RuntimeException("Esse filme não possui fitas validas"));
    }
}
