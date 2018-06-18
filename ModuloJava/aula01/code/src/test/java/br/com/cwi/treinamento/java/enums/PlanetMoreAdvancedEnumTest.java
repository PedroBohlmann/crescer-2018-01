package br.com.cwi.treinamento.java.enums;

import org.junit.Assert;
import org.junit.Test;

public class PlanetMoreAdvancedEnumTest {

    private double precision = 0.1;

    @Test
    public void deveCalcularGravidadeDoPlanetaTerra() {
        Assert.assertEquals(9.8, PlanetMoreAdvancedEnum.EARTH.surfaceGravity(), precision);
    }

    @Test
    public void deveObterDescricaoDoPlanetaTerra() {
        Assert.assertEquals("Terra { massa: 5,98e+24, diâmetro: 1,28e+07}", PlanetMoreAdvancedEnum.EARTH.toString());
    }

}