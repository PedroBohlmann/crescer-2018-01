package pistas;

import corredores.Corredor;

import java.util.HashMap;
import java.util.Map;

public class Pista {

    private int tamanho;
    private Map<Podium, Corredor> podiumCorredor;
    private int quantosChegaramNoPodium;

    public Pista(int tamanhoDaPista) {
        podiumCorredor = new HashMap<>();
        this.tamanho = tamanhoDaPista;
        quantosChegaramNoPodium=0;
    }

    public void adicionarCorredor(Corredor novoCorredor) {
        novoCorredor.associarAUmaPista(this);
    }

    public int getTamanhoDaPista() {
        return tamanho;
    }


    public void adicionarAoPodium(Corredor corredor) {
        if(quantosChegaramNoPodium<3){
            switch (quantosChegaramNoPodium){
                case 0:
                    podiumCorredor.put(Podium.PRIMEIRO_LUGAR,corredor);
                    quantosChegaramNoPodium++;
                    break;
                case 1:
                    podiumCorredor.put(Podium.SEGUNDO_LUGAR,corredor);
                    quantosChegaramNoPodium++;
                    break;
                case 2:
                    podiumCorredor.put(Podium.TERCEIRO_LUGAR,corredor);
                    quantosChegaramNoPodium++;
                    break;
            }
        }
    }

    public Corredor getCorredorNaPosicao(Podium podium){
        return podiumCorredor.get(podium);
    }

    public Casa getCasaOndeCorredorEsta(Corredor corredor){
        return corredor.getCasaAtual();
    }
}
