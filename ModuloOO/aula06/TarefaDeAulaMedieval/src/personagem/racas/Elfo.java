package personagem.racas;

import alvos.Alvo;
import personagem.Personagem;

public class Elfo extends Personagem {

    private int poderMagico;

    public Elfo(String nome, int poderDeAtaqueFisico, int poderMagico) {
        super(nome, poderDeAtaqueFisico);
        this.poderMagico = poderMagico;
    }

    @Override
    public void atacarAlvo(Alvo alvo){
        alvo.recebeAtaque(this.getPoderDeAtaqueTotal());
    }

    @Override
    public int getPoderDeAtaqueTotal(){
        return poderMagico+this.getPoderDeAtaqueFisico();
    }
}
