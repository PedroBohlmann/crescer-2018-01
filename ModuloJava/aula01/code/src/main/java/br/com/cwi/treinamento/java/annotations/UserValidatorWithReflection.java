package br.com.cwi.treinamento.java.annotations;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class UserValidatorWithReflection {

    public static <T> boolean isValidUser(T object) {
        Class<?> classe = object.getClass();

        for (Field field : classe.getDeclaredFields()) {
            if (field.isAnnotationPresent(MinAge.class)) {
                MinAge minAge = field.getAnnotation(MinAge.class);

                try{
                    field.setAccessible(true);
                    LocalDate birthDate = (LocalDate) field.get(object);

                    return Period.between(birthDate, LocalDate.now()).getYears() >= minAge.age();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

}
