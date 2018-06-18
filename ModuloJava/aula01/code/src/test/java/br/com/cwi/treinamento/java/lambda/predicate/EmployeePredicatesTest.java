package br.com.cwi.treinamento.java.lambda.predicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.cwi.treinamento.java.lambda.predicate.EmployeePredicates.*;
import static org.junit.Assert.*;

public class EmployeePredicatesTest {

    @Test
    public void shouldFilterEmployees() {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(new Employee[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10}));

        assertEquals("[Rick - 23, Ricky - 43, Jon - 26, Alex - 79, Naveen - 45]", filterEmployees(employees, isAdultMale()).toString());
        assertEquals("[Cristine - 19, Melissa - 68]", filterEmployees(employees, isAdultFemale()).toString());
        assertEquals("[Ricky - 43, Melissa - 68, Alex - 79, Naveen - 45]", filterEmployees(employees, isAgeMoreThan(35)).toString());
        assertTrue(isAgeMoreThan(35).test(e8));
    }

}