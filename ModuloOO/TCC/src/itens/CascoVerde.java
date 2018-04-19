package itens;

import corredores.Corredor;
import tipos_de_itens.ataque.ItemDeAtaque;

public class CascoVerde implements ItemDeAtaque {

    private int dano;

    public CascoVerde() {
        this.dano = 3;
    }

    @Override
    public void usar(Corredor corredor) {
        corredor.recebeDano(this.dano);
    }
}
