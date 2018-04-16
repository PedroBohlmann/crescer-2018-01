package personagem.racas;

import alvos.Alvo;
import personagem.Personagem;

public class Orc extends Personagem {

    private boolean temGarra;

    public Orc(String nome, int poderDeAtaqueFisico, boolean temGarra) {
        super(nome, poderDeAtaqueFisico);
        this.temGarra = temGarra;
    }

    @Override
    public void atacarAlvo(Alvo alvo){
        alvo.recebeAtaque(getPoderDeAtaqueTotal());
    }

    @Override
    public int getPoderDeAtaqueTotal(){
        if(temGarra){
            return this.getPoderDeAtaqueFisico()*5;
        }else{
            return this.getPoderDeAtaqueFisico();
        }
    }
}
