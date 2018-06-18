package br.com.cwi.treinamento.java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HashMapTest {

    @Test
    public void shouldAddElementsOnMap() {
        Map<String, String> states = new HashMap<>();
        states.put("SP", "São Paulo");
        states.put("RJ", "Rio De Janeiro");
        states.put("AC", "Acre");
        states.put("AM", "Amazonas");
        states.put("SC", "Santa Catarina");
        states.put("RS", "Rio Grande do Sul");

        assertEquals(6, states.size());
        assertEquals("Rio Grande do Sul", states.get("RS"));
    }

    @Test
    public void shouldPrintAllStatesInitials() {
        Map<String, String> states = new HashMap<>();
        states.put("SP", "São Paulo");
        states.put("RJ", "Rio De Janeiro");
        states.put("AC", "Acre");
        states.put("AM", "Amazonas");
        states.put("SC", "Santa Catarina");
        states.put("RS", "Rio Grande do Sul");

        for (String s : states.keySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void shouldPrintAllStatesNames() {
        Map<String, String> states = new HashMap<>();
        states.put("SP", "São Paulo");
        states.put("RJ", "Rio De Janeiro");
        states.put("AC", "Acre");
        states.put("AM", "Amazonas");
        states.put("SC", "Santa Catarina");
        states.put("RS", "Rio Grande do Sul");

        for (String s : states.values()) {
            System.out.println(s);
        }
    }

    @Test
    public void shouldPrintAllStates() {
        Map<String, String> states = new HashMap<>();
        states.put("SP", "São Paulo");
        states.put("RJ", "Rio De Janeiro");
        states.put("AC", "Acre");
        states.put("AM", "Amazonas");
        states.put("SC", "Santa Catarina");
        states.put("RS", "Rio Grande do Sul");

        for (Map.Entry<String, String> s : states.entrySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void shouldPrintStatesByRegion() {
        List<String> sudeste = new ArrayList<>();
        sudeste.add("São Paulo");
        sudeste.add("Rio De Janeiro");

        List<String> norte = new ArrayList<>();
        norte.add("Acre");
        norte.add("Amazonas");

        List<String> sul = new ArrayList<>();
        sul.add("Santa Catarina");
        sul.add("Rio Grande do Sul");

        Map<String, List<String>> regioes = new HashMap<>();
        regioes.put("Sudeste", sudeste);
        regioes.put("Norte", norte);
        regioes.put("Sul", sul);

        for (Map.Entry<String, List<String>> entry : regioes.entrySet()) {
            System.out.println("Os estados abaixo pertencem a região " + entry.getKey());

            for (String state : entry.getValue()) {
                System.out.println(state);
            }

            System.out.println();
        }
    }
}
