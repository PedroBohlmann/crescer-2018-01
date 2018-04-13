package defesas;

import armas.Arma;

public class Muro {
    private int pontosDeDefesa;

    public Muro() {
        this.pontosDeDefesa = 10000;
    }

    public void recebeAtaque(Arma arma){
        pontosDeDefesa=pontosDeDefesa- arma.getPoderDeAtaque();
    }

    public int getPontosDeDefesa() {
        return pontosDeDefesa;
    }
}
