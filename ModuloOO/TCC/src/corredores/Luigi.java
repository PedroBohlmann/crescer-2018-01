package corredores;

import pistas.Casa;
import pistas.Pista;

public class Luigi extends Corredor {
    public Luigi() {
        super(5);
    }

    @Override
    public void andar() {
        Pista pista = this.getPistaQuePertence();
        Casa casa = this.getCasaAtual();
        int quantidadeDeCasas = this.getQuantidadeDeCasasQuePercorre();
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
