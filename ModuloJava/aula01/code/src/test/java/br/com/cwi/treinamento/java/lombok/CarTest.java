package br.com.cwi.treinamento.java.lombok;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void deveSerPossivelDefinirEObterAtributos() {

        Car kaPreto = new Car();
        kaPreto.setModel("Ka");
        kaPreto.setBrand(Brand.FORD);
        kaPreto.setColor(new Color(0, 0, 0));

        Assert.assertEquals("Ka", kaPreto.getModel());
        Assert.assertEquals(Brand.FORD, kaPreto.getBrand());
        Assert.assertEquals(0, kaPreto.getColor().getRed());
        Assert.assertEquals(0, kaPreto.getColor().getGreen());
        Assert.assertEquals(0, kaPreto.getColor().getBlue());

    }

    @Test
    public void deveSerPossivelCompararDoisCarros() {

        Car kaPreto = new Car();
        kaPreto.setModel("Ka");
        kaPreto.setBrand(Brand.FORD);
        kaPreto.setColor(new Color(0, 0, 0));

        Car outroKaPreto = new Car();
        outroKaPreto.setModel("Ka");
        outroKaPreto.setBrand(Brand.FORD);
        outroKaPreto.setColor(new Color(0, 0, 0));

        Assert.assertEquals(kaPreto, outroKaPreto);

    }

}