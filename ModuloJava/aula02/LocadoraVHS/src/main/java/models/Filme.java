package models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Filme {

    private String titulo;
    private double valor;
    private int prazoEntrega;
    private int idFitas;

    private List<Fita> fitas;

    public Filme(String titulo, double valor, int prazoEntrega) {
        this.titulo = titulo;
        this.valor = valor;
        this.prazoEntrega = prazoEntrega;
        this.fitas = new ArrayList<>();
        this.idFitas = 0;
    }

    public Fita primeiraFitaNaoLocada(){
        return fitas.stream().filter(p->!p.isLocado()).findFirst().orElseThrow(() -> new RuntimeException("Esse filme não possui fitas validas"));
    }

    public void adicionaFita(Fita fita){
        fitas.add(fita);
        fita.setFilme(this);
        fita.setIdFita(idFitas++);
    }
}
