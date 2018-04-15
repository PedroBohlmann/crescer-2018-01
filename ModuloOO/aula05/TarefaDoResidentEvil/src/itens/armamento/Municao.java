package itens.armamento;

import inventario.Inventario;
import itens.Item;

public class Municao extends Item {

    private int balas;

    public Municao(int tilesOcupadosEmX, int tilesOcupadosEmY, double peso, String nome, int balas) {
        super(tilesOcupadosEmX, tilesOcupadosEmY, peso, nome);
        this.balas = balas;
    }

    public int retiraBalasParaRecarregar(int quantidadeASerRetirado) {
        if (balas < quantidadeASerRetirado) {
            int retorno = this.balas;
            this.balas = 0;
            this.getInventarioAQuePertence().removerItem(this);
            return retorno;
        } else {
            this.balas -= quantidadeASerRetirado;
            return quantidadeASerRetirado;
        }
    }//retirar do inventario

    public int getBalas() {
        return balas;
    }
}
