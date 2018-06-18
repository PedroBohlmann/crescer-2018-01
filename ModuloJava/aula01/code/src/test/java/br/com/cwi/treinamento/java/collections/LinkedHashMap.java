package br.com.cwi.treinamento.java.collections;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class LinkedHashMap {

    @Test
    public void mapShouldMaintainTheOrderThatTheElementsHaveBeenInserted() {
        Map<Integer, String> map = new java.util.LinkedHashMap<>();
        map.put(2, "valor");
        map.put(1, "valor");
        map.put(3, "valor");

        Integer[] keys = map.keySet().toArray(new Integer[0]);

        assertEquals(new Integer(2), keys[0]);
        assertEquals(new Integer(1), keys[1]);
        assertEquals(new Integer(3), keys[2]);
    }

}
