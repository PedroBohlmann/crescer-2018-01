package pistas;

import pistas.casas.Casa;

public class RainbowRoad extends Pista {

    public RainbowRoad(Casa[] casasCustomizada) {
        super(25);
        Casa[] casasDaPista = super.getCasasDaPista();

        for (int i = 0; i < casasCustomizada.length; i++) {
            int posicaoCasaCustomizada = casasCustomizada[i].getNumeroDaCasa();
            casasDaPista[posicaoCasaCustomizada] = casasCustomizada[i];
        }
    }
}
