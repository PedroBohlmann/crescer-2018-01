package pistas.casas;

import corredores.Corredor;

public class CasaTurbo extends CasaCustomizada {

    public CasaTurbo(int numeroDaCasa) {
        super(numeroDaCasa);
    }

    @Override
    public void aplicaEfeitoNoCorredor(Corredor corredor) {
        corredor.andar();
    }
}
