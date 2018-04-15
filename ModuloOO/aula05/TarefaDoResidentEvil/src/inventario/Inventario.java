package inventario;

import itens.Item;

import java.util.ArrayList;

public class Inventario {

    private Item matrizInventario[][];
    private ArrayList<ItemNoInventario> listaDeItens;

    public Inventario(int tamanhoEmX, int tamanhoEmY) {
        matrizInventario = new Item[tamanhoEmX][tamanhoEmY];
        listaDeItens = new ArrayList<>();
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
        retorno = percorreAMatrizParaVerificarSeCabe(item);
        if (retorno) {
            return retorno;
        } else {
            item.virar();
            retorno = percorreAMatrizParaVerificarSeCabe(item);
            return retorno;
        }
    }

    private boolean percorreAMatrizParaVerificarSeCabe(Item item) {
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
                    colunaInicial = (j - quantidadeConsecutivosLivres) + 1;//+1 para normalizar devido ao fato que a matriz começa em 0
                    linhasLivres++;
                    break;
                }
            }
            quantidadeConsecutivosLivres = 0;
            if (linhasLivres == item.getTilesOcupadosEmX()) {
                return true;
            }
        }
        return false;

    }

    public void adicionarItem(Item item) {
        if (this.verificaSeItemCabe(item) && !verificaSeItemJaEstaNoInventario(item)) {
            int posicaoValidaEmX = 0;
            int posicaoValidaEmY = 0;
            forDeFora:
            for (int i = 0; i < matrizInventario.length; i++) {
                for (int j = 0; j < matrizInventario[i].length; j++) {
                    if (verificaSeItemCabeNaPosicao(i, j, item)) {
                        posicaoValidaEmX = i;
                        posicaoValidaEmY = j;
                        break forDeFora;
                    }
                }
            }

            int quantidadeDeItemPorLinha = item.getTilesOcupadosEmX();
            int quantidadeDeItemPorColuna = item.getTilesOcupadosEmY();

            ItemNoInventario itemNoInventario = new ItemNoInventario(item);
            item.associaInventario(this);
            for (int i = posicaoValidaEmX; i < matrizInventario.length; i++) {
                for (int j = posicaoValidaEmY; j < matrizInventario[i].length; j++) {
                    if (quantidadeDeItemPorColuna == 0) {
                        break;
                    }
                    matrizInventario[i][j] = item;
                    quantidadeDeItemPorColuna--;
                    itemNoInventario.addPosicao(i, j);
                }
                quantidadeDeItemPorColuna = item.getTilesOcupadosEmY();
                quantidadeDeItemPorLinha--;
                if (quantidadeDeItemPorLinha == 0) {
                    break;
                }
            }
            listaDeItens.add(itemNoInventario);
        }
    }

    public Item pegaItemNaPosicao(int x, int y) {
        return matrizInventario[x][y];
    }


    private boolean verificaSeItemCabeNaPosicao(int linha, int coluna, Item item) {
        int quantidadeDeItemPorLinha = item.getTilesOcupadosEmX();
        int quantidadeDeItemPorColuna = item.getTilesOcupadosEmY();

        for (int i = linha; i < matrizInventario.length; i++) {
            for (int j = coluna; j < matrizInventario[i].length; j++) {
                if (quantidadeDeItemPorColuna == 0) {
                    break;
                }
                if (matrizInventario[i][j] != null) {
                    return false;
                }
                quantidadeDeItemPorColuna--;
            }
            quantidadeDeItemPorColuna = item.getTilesOcupadosEmY();
            quantidadeDeItemPorLinha--;
            if (quantidadeDeItemPorLinha == 0) {
                break;
            }
        }
        return true;
    }

    private boolean verificaSeItemJaEstaNoInventario(Item item) {
        for (ItemNoInventario itemAtual : listaDeItens) {
            if (itemAtual.getItemArmazenado() == item) {
                return true;
            }
        }
        return false;
    }

    public void removerItem(Item item) {
        for (int i = 0; i < listaDeItens.size(); i++) {
            if (listaDeItens.get(i).getItemArmazenado() == item) {
                Item itemAtual = listaDeItens.get(i).getItemArmazenado();
                int[][] posicoesOcupadas = listaDeItens.get(i).getPosicoesQueOItemOcupa();
                listaDeItens.remove(itemAtual);
                for (int j = 0; i <=posicoesOcupadas.length; i++) {
                    int x = posicoesOcupadas[j][0];
                    int y = posicoesOcupadas[j][1];

                    matrizInventario[x][y] = null;
                }
            }
        }
    }

    public Item maiorItem(){
        if(!listaDeItens.isEmpty()){
            Item maiorItem=listaDeItens.get(0).getItemArmazenado();
            for(int i=0;i<listaDeItens.size();i++){
                if(maiorItem.tamanhoEmTiles()<listaDeItens.get(i).getItemArmazenado().tamanhoEmTiles()){
                    maiorItem=listaDeItens.get(i).getItemArmazenado();
                }
            }
            return maiorItem;
        }
        return null;
    }

    public int pesoTotal(){
        int pesoTotal=0;
        for(int i=0;i<listaDeItens.size();i++){
            pesoTotal+=listaDeItens.get(i).getItemArmazenado().getPeso();
        }
        return pesoTotal;
    }

}
