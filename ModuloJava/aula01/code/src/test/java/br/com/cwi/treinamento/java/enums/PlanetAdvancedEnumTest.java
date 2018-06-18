package br.com.cwi.treinamento.java.enums;

import org.junit.Assert;
import org.junit.Test;

public class PlanetAdvancedEnumTest {

    private double precision = 0.1;

    @Test
    public void deveObterMassaDoPlanetaTerra() {
        Assert.assertEquals(5.976e+24, PlanetAdvancedEnum.EARTH.getMass(), precision);
    }

    @Test
    public void deveObterRaioDoPlanetaTerra() {
        Assert.assertEquals(6.37814e6, PlanetAdvancedEnum.EARTH.getRadius(), precision);
    }

}