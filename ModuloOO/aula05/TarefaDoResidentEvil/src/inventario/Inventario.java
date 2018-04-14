package inventario;

import itens.Item;

public class Inventario {

    private Item matrizInventario[][];

    public Inventario(int tamanhoEmX,int tamanhoEmY) {
        matrizInventario = new Item[tamanhoEmX][tamanhoEmY];
    }


}
