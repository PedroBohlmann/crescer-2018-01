package inventario;

import itens.Item;

public class Inventario {

    private ItemNoInventario matrizInventario[][];

    public Inventario(int tamanhoEmX,int tamanhoEmY) {
        matrizInventario = new ItemNoInventario[tamanhoEmX][tamanhoEmY];
    }

    public int verificaEspacoDiponiveis(){
        int espacos=0;
        for(int i=0;i<matrizInventario.length;i++){
            for(int j=0;j<matrizInventario[i].length;j++){
                if(matrizInventario[i][j]==null) {
                    espacos++;
                }
            }
        }
        return espacos;
    }

    public boolean verificaSeCabeItem(Item item){
        
    }




}
