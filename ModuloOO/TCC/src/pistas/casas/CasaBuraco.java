package pistas.casas;

import corredores.Corredor;

public class CasaBuraco extends CasaCustomizada {

    public CasaBuraco(int numeroDaCasa) {
        super(numeroDaCasa);
    }

    @Override
    public void aplicaEfeitoNoCorredor(Corredor corredor) {
        int danoASerTomado = (int) Math.ceil(getNumeroDaCasa() / 2);
        corredor.recebeDano(danoASerTomado);
    }
}
