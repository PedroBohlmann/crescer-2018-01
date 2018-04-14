package itens;

public class Item {

    private int tilesOcupadosEmX;
    private int tilesOcupadosEmY;
    private double peso;
    private String nome;

    public Item(int tilesOcupadosEmX, int tilesOcupadosEmY, double peso, String nome) {
        this.tilesOcupadosEmX = tilesOcupadosEmX;
        this.tilesOcupadosEmY = tilesOcupadosEmY;
        this.peso = peso;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getTilesOcupadosEmX() {
        return tilesOcupadosEmX;
    }

    public int getTilesOcupadosEmY() {
        return tilesOcupadosEmY;
    }
    public void virar(){
        int auxiliar=tilesOcupadosEmX;
        tilesOcupadosEmX=tilesOcupadosEmY;
        tilesOcupadosEmY=auxiliar;
    }
}
