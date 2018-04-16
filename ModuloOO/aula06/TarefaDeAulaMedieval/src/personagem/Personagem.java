package personagem;

import alvos.Alvo;

public class Personagem {

    private String nome;
    private int poderDeAtaqueFisico;

    public Personagem(String nome, int poderDeAtaqueFisico) {
        this.nome = nome;
        this.poderDeAtaqueFisico = poderDeAtaqueFisico;
    }

    public void atacarAlvo(Alvo alvo) {
        alvo.recebeAtaque(poderDeAtaqueFisico);
    }// TODO: A ser criado

    public int getPoderDeAtaqueFisico() {
        return poderDeAtaqueFisico;
    }

    public int getPoderDeAtaqueTotal(){
        return poderDeAtaqueFisico;
    }

    public String getNome() {
        return nome;
    }
}
