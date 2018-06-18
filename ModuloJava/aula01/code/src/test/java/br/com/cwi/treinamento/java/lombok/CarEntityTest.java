package br.com.cwi.treinamento.java.lombok;

import org.junit.Assert;
import org.junit.Test;

public class CarEntityTest {

    @Test
    public void deveCompararCarrosPeloSeuId() {
        CarEntity fordKaPreto = new CarEntity();
        fordKaPreto.setId(1L);
        fordKaPreto.setModel("Ka");
        fordKaPreto.setBrand(Brand.FORD);
        fordKaPreto.setColor(new Color(0, 0, 0));

        CarEntity kiaSoulBranco = new CarEntity();
        kiaSoulBranco.setId(1L);
        kiaSoulBranco.setModel("Soul");
        kiaSoulBranco.setBrand(Brand.KIA);
        kiaSoulBranco.setColor(new Color(255, 255, 255));

        Assert.assertEquals(fordKaPreto, kiaSoulBranco);
    }

    @Test
    public void deveIgnorarIdAoConverterParaString() {
        CarEntity fordKaPreto = new CarEntity();
        fordKaPreto.setId(1L);
        fordKaPreto.setModel("Ka");
        fordKaPreto.setBrand(Brand.FORD);
        fordKaPreto.setColor(new Color(0, 0, 0));

        Assert.assertEquals("CarEntity(model=Ka, brand=FORD)", fordKaPreto.toString());
    }
}