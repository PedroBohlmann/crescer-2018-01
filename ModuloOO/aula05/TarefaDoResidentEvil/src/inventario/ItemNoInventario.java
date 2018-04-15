package inventario;

import itens.Item;

public class ItemNoInventario {

    private Item itemArmazenado;
    private int posicoesQueOItemOcupa[][];
    private int ultimaLinhaUtilizada;


    public ItemNoInventario(Item item) {
        this.itemArmazenado = item;
        int quantidadeDeTiles = this.itemArmazenado.getTilesOcupadosEmX() * this.itemArmazenado.getTilesOcupadosEmY();
        posicoesQueOItemOcupa = new int[quantidadeDeTiles][2];
        ultimaLinhaUtilizada = 0;
    }

    public int[][] getPosicoesQueOItemOcupa() {
        return posicoesQueOItemOcupa;
    }

    public void addPosicao(int x, int y) {
        if (ultimaLinhaUtilizada < posicoesQueOItemOcupa.length) {
            posicoesQueOItemOcupa[ultimaLinhaUtilizada][0] = x;
            posicoesQueOItemOcupa[ultimaLinhaUtilizada][1] = y;
        }
    }

    public Item getItemArmazenado() {
        return itemArmazenado;
    }

}
