package personagem.racas;

import alvos.Alvo;
import personagem.Personagem;

public class Humano extends Personagem {

    private boolean temArco;

    public Humano(String nome, int poderDeAtaqueFisico, boolean temArco) {
        super(nome, poderDeAtaqueFisico);
        this.temArco = temArco;
    }

    @Override
    public void atacarAlvo(Alvo alvo){
        alvo.recebeAtaque(getPoderDeAtaqueTotal());
    }

    @Override
    public int getPoderDeAtaqueTotal(){
        if(temArco){
            return this.getPoderDeAtaqueFisico()*3;
        }else{
            return this.getPoderDeAtaqueFisico();
        }
    }
}
