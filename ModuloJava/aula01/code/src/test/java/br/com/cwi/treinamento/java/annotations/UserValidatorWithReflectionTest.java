package br.com.cwi.treinamento.java.annotations;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserValidatorWithReflectionTest {

    @Test
    public void shouldReturnTrueWhenUserIsOldEnough() {
        User user = new User("Robson", LocalDate.of(1989, 7, 2));

        assertTrue(UserValidatorWithReflection.isValidUser(user));
    }

    @Test
    public void shouldReturnTrueWhenUserIsNotOldEnough() {
        User user = new User("Robson", LocalDate.of(2005, 7, 2));

        assertFalse(UserValidatorWithReflection.isValidUser(user));
    }
}