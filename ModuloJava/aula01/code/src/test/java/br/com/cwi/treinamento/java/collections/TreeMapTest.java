package br.com.cwi.treinamento.java.collections;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class TreeMapTest {

    @Test
    public void mapShouldBeOrderedWhenUsingTreeMap() {
        Map<Integer, String> map = new TreeMap<>();

        map.put(3, "valor");
        map.put(2, "valor");
        map.put(1, "valor");
        map.put(5, "valor");
        map.put(4, "valor");

        assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
    }

    @Test
    public void mapShouldBeOrderedReversedWhenUsingTreeMapAndPassReversedOrderComparator() {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

        map.put(3, "valor");
        map.put(2, "valor");
        map.put(1, "valor");
        map.put(5, "valor");
        map.put(4, "valor");

        assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());
    }

    @Test
    public void shouldReturnCorrectQueriesFromTreeMap() {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3, "valor");
        map.put(2, "valor");
        map.put(1, "valor");
        map.put(5, "valor");
        map.put(4, "valor");

        assertEquals(new Integer(5), map.lastKey());
        assertEquals(new Integer(1), map.firstKey());
        assertEquals("[1, 2]", map.headMap(3).keySet().toString());
        assertEquals("[3, 4, 5]", map.tailMap(3).keySet().toString());
    }

}