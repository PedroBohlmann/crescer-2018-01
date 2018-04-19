package pistas.casas;

import corredores.Corredor;

public abstract class CasaCustomizada extends Casa {

    public CasaCustomizada(int numeroDaCasa) {
        super(numeroDaCasa);
    }

    public abstract void aplicaEfeitoNoCorredor(Corredor corredor);
}
