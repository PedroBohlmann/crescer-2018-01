package corredores;

import pistas.Casa;
import pistas.Pista;

public class Mario extends Corredor {
    public Mario() {
        super(7);
    }

    @Override
    public void andar() {
        Pista pista = this.getPistaQuePertence();
        Casa casa = this.getCasaAtual();
        int quantidadeDeCasas = this.getQuantidadeDeCasasQuePercorre()+1;
        if (pista != null) {
            int numeroDaCasaAtual = casa.getNumeroDaCasa();
            if ((numeroDaCasaAtual + quantidadeDeCasas) <= pista.getTamanhoDaPista()) {
                setCasaAtual(new Casa(numeroDaCasaAtual + quantidadeDeCasas));
            } else {
                pista.adicionarAoPodium(this);
            }
        }
    }
}
