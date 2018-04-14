package inventario;

import itens.Item;

public class ItemNoInventario  {

    private Item itemArmazenado;
    private int posicoesQueOItemOcupa[][];


    public ItemNoInventario(Item item){
        this.itemArmazenado=item;
        int quantidadeDeTiles=item.getTilesOcupadosEmX()*item.getTilesOcupadosEmY();
        posicoesQueOItemOcupa =new int[quantidadeDeTiles][2];
    }

    public int[][] getPosicoesQueOItemOcupa() {
        return posicoesQueOItemOcupa;
    }


}
