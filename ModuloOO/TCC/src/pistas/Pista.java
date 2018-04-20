package pistas;

import corredores.Corredor;
import pistas.casas.Casa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pista {

    private int tamanho;
    private Map<Podium, Corredor> podiumCorredor;
    private int quantosChegaramNoPodium;
    private Casa[] casasDaPista;
    private List<Corredor> listaDeCorredores;

    public Pista(int tamanhoDaPista) {
        this.podiumCorredor = new HashMap<>();
        this.tamanho = tamanhoDaPista;
        this.quantosChegaramNoPodium = 0;
        this.casasDaPista = new Casa[tamanhoDaPista];

        for (int i = 0; i < tamanhoDaPista; i++) {
            this.casasDaPista[i] = new Casa(i);
        }
        this.listaDeCorredores = new ArrayList<>();
    }

    public void adicionarCorredor(Corredor novoCorredor) {
        novoCorredor.associarAUmaPista(this, casasDaPista[0]);
        this.listaDeCorredores.add(novoCorredor);
    }

    public int getTamanhoDaPista() {
        return tamanho;
    }

    public void adicionarAoPodium(Corredor corredor) {
        if (quantosChegaramNoPodium < 3) {
            if (corredor.getCasaAtual() == null) {
                switch (quantosChegaramNoPodium) {
                    case 0:
                        podiumCorredor.put(Podium.PRIMEIRO_LUGAR, corredor);
                        quantosChegaramNoPodium++;
                        break;
                    case 1:
                        podiumCorredor.put(Podium.SEGUNDO_LUGAR, corredor);
                        quantosChegaramNoPodium++;
                        break;
                    case 2:
                        podiumCorredor.put(Podium.TERCEIRO_LUGAR, corredor);
                        quantosChegaramNoPodium++;
                        break;
                }
            }
        }
    }

    public Corredor getCorredorNaPosicao(Podium podium) {
        return podiumCorredor.get(podium);
    }

    public Casa getCasaOndeCorredorEsta(Corredor corredor) {
        return corredor.getCasaAtual();
    }

    public Casa[] getCasasDaPista() {
        return casasDaPista;
    }

    public Casa getCasaPelaPosicao(int posicao) {
        return casasDaPista[posicao];
    }

    public void corredorSaiDaCorrida(Corredor corredor) {
        listaDeCorredores.remove(corredor);
    }

    public List<Corredor> getListaDeCorredores() {
        return listaDeCorredores;
    }
}
