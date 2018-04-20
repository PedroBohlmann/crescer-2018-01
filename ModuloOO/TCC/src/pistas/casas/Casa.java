package pistas.casas;

import corredores.Corredor;

public class Casa {

    private int numeroDaCasa;

    public Casa(int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void adicionarCorredor(Corredor corredor) {
        corredor.avancaParaACasa(this);
    }
}
