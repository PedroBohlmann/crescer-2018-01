package br.com.cwi.treinamento.java.enums;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PlanetSimpleEnumTest {

    @Test
    public void deveProveNomeDeUmPlanetaSimples() {
        Assert.assertEquals("EARTH", PlanetSimpleEnum.EARTH.name());
    }

    @Test
    public void devePrintarUmPlanetaSimples() {
        Assert.assertEquals("EARTH", PlanetSimpleEnum.EARTH.toString());
    }

    @Test
    public void deveObterTodosPlanetasSimples() {
        PlanetSimpleEnum[] planets = PlanetSimpleEnum.values();

        Assert.assertEquals(PlanetSimpleEnum.MERCURY, planets[0]);
        Assert.assertEquals(PlanetSimpleEnum.VENUS, planets[1]);
        Assert.assertEquals(PlanetSimpleEnum.EARTH, planets[2]);
        Assert.assertEquals(PlanetSimpleEnum.MARS, planets[3]);
        Assert.assertEquals(PlanetSimpleEnum.JUPITER, planets[4]);
        Assert.assertEquals(PlanetSimpleEnum.SATURN, planets[5]);
        Assert.assertEquals(PlanetSimpleEnum.URANUS, planets[6]);
        Assert.assertEquals(PlanetSimpleEnum.NEPTUNE, planets[7]);
        Assert.assertEquals(PlanetSimpleEnum.PLUTO, planets[8]);
    }

    @Test
    public void deveConstruirUmPlanetSimplePeloNome() {
        Assert.assertEquals(PlanetSimpleEnum.EARTH, PlanetSimpleEnum.valueOf("EARTH"));
    }

}