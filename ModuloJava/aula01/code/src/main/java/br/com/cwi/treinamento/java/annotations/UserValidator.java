package br.com.cwi.treinamento.java.annotations;

import java.time.LocalDate;
import java.time.Period;

public class UserValidator {

    public boolean isValidUser(User user) {
        return Period.between(user.getBirthDate(), LocalDate.now()).getYears() >= 18;
    }

}
