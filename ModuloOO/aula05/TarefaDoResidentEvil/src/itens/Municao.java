package itens;

import inventario.Inventario;

public class Municao extends Item {

    private int balas;
    private Inventario inventarioAQuePertence;
    public Municao(int tilesOcupadosEmX, int tilesOcupadosEmY, double peso, String nome, int balas) {
        super(tilesOcupadosEmX, tilesOcupadosEmY, peso, nome);
        this.balas = balas;
    }

    public void associarAInventario(Inventario inventario){
        this.inventarioAQuePertence=inventario;
    }

    public int retiraBalasParaRecarregar(int quantidadeASerRetirado){
        if(balas<quantidadeASerRetirado){
            int retorno= this.balas;
            this.balas=0;
            return retorno;
        }
        else{
            this.balas-=quantidadeASerRetirado;
            return quantidadeASerRetirado;
        }
    }//retirar do inventario
    public int getBalas(){
        return balas;
    }
}
