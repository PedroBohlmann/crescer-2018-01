package itens;

public class Arma extends Item {

    private int capacidade;
    private int balasNaArma;
    private int balasUtilizadasEmDisparo;

    public Arma(int tilesOcupadosEmX, int tilesOcupadosEmY, double peso, String nome, int capacidade, int balasUtilizadasEmDisparo) {
        super(tilesOcupadosEmX, tilesOcupadosEmY, peso, nome);
        this.capacidade = capacidade;
        this.balasUtilizadasEmDisparo = balasUtilizadasEmDisparo;
        balasNaArma = 0;
    }

    public void recarrega(Municao municao){
        this.balasNaArma=municao.retiraBalasParaRecarregar(capacidade-balasNaArma);
    }

    public void dispara(){
        if(balasNaArma>0) {
            this.balasNaArma -= balasUtilizadasEmDisparo;
        }
    }

    public int getBalasNaArma() {
        return balasNaArma;
    }
}
