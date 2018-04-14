package inventario;

import itens.Item;

public class Inventario {

    private ItemNoInventario matrizInventario[][];

    public Inventario(int tamanhoEmX, int tamanhoEmY) {
        matrizInventario = new ItemNoInventario[tamanhoEmX][tamanhoEmY];
    }

    public int verificaEspacoDiponiveis() {
        int espacos = 0;
        for (int i = 0; i < matrizInventario.length; i++) {
            for (int j = 0; j < matrizInventario[i].length; j++) {
                if (matrizInventario[i][j] == null) {
                    espacos++;
                }
            }
        }
        return espacos;
    }

    public boolean verificaSeItemCabe(Item item) {
        boolean retorno;
        retorno=percorreAMatrizParaVerificarSeCabe(item);
        if(retorno){
            return retorno;
        }else {
            item.virar();
            retorno = percorreAMatrizParaVerificarSeCabe(item);
            return retorno;
        }
    }

    private boolean percorreAMatrizParaVerificarSeCabe(Item item){
        int quantidadeConsecutivosLivres = 0;
        int linhasLivres = 0;
        int colunaInicial = 0;

        for (int i = 0; i < matrizInventario.length; i++) {
            for (int j = colunaInicial; j < matrizInventario[i].length; j++) {
                if (matrizInventario[i][j] == null) {
                    quantidadeConsecutivosLivres++;
                } else {
                    quantidadeConsecutivosLivres = 0;
                }
                if (quantidadeConsecutivosLivres == item.getTilesOcupadosEmY()) {
                    colunaInicial = (j - quantidadeConsecutivosLivres)+1;//+1 para normalizar devido ao fato que a matriz começa em 0
                    linhasLivres++;
                    break;
                }
            }
            quantidadeConsecutivosLivres=0;
            if (linhasLivres == item.getTilesOcupadosEmX()) {
                return true;
            }
        }
        return false;
    }


}
