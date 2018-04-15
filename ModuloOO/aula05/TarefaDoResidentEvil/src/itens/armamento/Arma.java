package itens.armamento;

import itens.Item;
import itens.armamento.Municao;

public class Arma extends Item {

    private int capacidade;
    private int balasNaArma;
    private int balasUtilizadasEmDisparo;
    private String tipoDeMunicaoUtilizada;

    public Arma(int tilesOcupadosEmX, int tilesOcupadosEmY, double peso, String nome, int capacidade, int balasUtilizadasEmDisparo, String tipoDeMunicaoUtilizada) {
        super(tilesOcupadosEmX, tilesOcupadosEmY, peso, nome);
        this.capacidade = capacidade;
        this.balasUtilizadasEmDisparo = balasUtilizadasEmDisparo;
        this.tipoDeMunicaoUtilizada = tipoDeMunicaoUtilizada;
        balasNaArma = 0;

    }

    public void recarrega(Municao municao) {
        if (tipoDeMunicaoUtilizada.equalsIgnoreCase(municao.getNome())) {
            this.balasNaArma = municao.retiraBalasParaRecarregar(capacidade - balasNaArma);
        }
    }

    public void dispara() {
        if (balasNaArma > 0) {
            this.balasNaArma -= balasUtilizadasEmDisparo;
        }
    }

    public int getBalasNaArma() {
        return balasNaArma;
    }

    public void recarrega(){
        Municao municao= getInventarioAQuePertence().procuraMunicaoPorNome(tipoDeMunicaoUtilizada);
        if(municao!=null){
            this.balasNaArma = municao.retiraBalasParaRecarregar(capacidade - balasNaArma);
        }
    }
}
