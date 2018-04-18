package corredores;

import pistas.Casa;
import pistas.Pista;

public class Corredor {

    private int vida;
    private int quantidadeDeCasasQuePercorre;

    private Pista pistaQuePertence;
    private Casa casaAtual;

    public Corredor(int vida) {
        this.vida = vida;
        this.quantidadeDeCasasQuePercorre = 3;
    }

    public void andar() {
        if (pistaQuePertence != null) {
            int numeroDaCasaAtual = casaAtual.getNumeroDaCasa();
            if ((numeroDaCasaAtual + quantidadeDeCasasQuePercorre) < pistaQuePertence.getTamanhoDaPista()) {
                this.casaAtual = new Casa(numeroDaCasaAtual + quantidadeDeCasasQuePercorre);
            } else {
                //ganha
            }
        }
    }


    public void associarAUmaPista(Pista pista) {
        this.pistaQuePertence = pista;
        this.casaAtual = new Casa(0);
    }


}
