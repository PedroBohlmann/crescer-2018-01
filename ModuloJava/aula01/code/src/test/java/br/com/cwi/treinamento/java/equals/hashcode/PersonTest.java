package br.com.cwi.treinamento.java.equals.hashcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void comparasionShouldFailWithoutEquals() {
        PersonWithoutEqualsHashCode p1 = new PersonWithoutEqualsHashCode("02442971003", "Robson", 29);
        PersonWithoutEqualsHashCode p2 = new PersonWithoutEqualsHashCode("02442971003", "Robson", 29);

        assertFalse(p1.equals(p2));
    }

    @Test
    public void featuresBasedOnHashFailWithoutHashCode() {
        PersonWithoutEqualsHashCode p1 = new PersonWithoutEqualsHashCode("02442971003", "Robson", 29);
        PersonWithoutEqualsHashCode p2 = new PersonWithoutEqualsHashCode("02442971003", "Robson", 29);

        Map<PersonWithoutEqualsHashCode, Integer> persons = new HashMap<>();
        persons.put(p1, 0);
        persons.put(p2, 0);

        assertEquals(2, persons.size());
    }

    @Test
    public void comparasionShouldWorksWhenOverrideEquals() {
        PersonWithEqualsHashCode p1 = new PersonWithEqualsHashCode("02442971003", "Robson", 29);
        PersonWithEqualsHashCode p2 = new PersonWithEqualsHashCode("02442971003", "Robson", 29);

        assertTrue(p1.equals(p2));
    }

    @Test
    public void featuresBasedOnHashFailWorksWhenOverrideHashCode() {
        PersonWithEqualsHashCode p1 = new PersonWithEqualsHashCode("02442971003", "Robson", 29);
        PersonWithEqualsHashCode p2 = new PersonWithEqualsHashCode("02442971003", "Robson", 29);

        Map<PersonWithEqualsHashCode, Integer> persons = new HashMap<>();
        persons.put(p1, 0);
        persons.put(p2, 0);

        assertEquals(1, persons.size());
    }

}
