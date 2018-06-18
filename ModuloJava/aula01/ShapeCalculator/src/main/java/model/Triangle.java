package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Triangle extends Shape {

    private double sidaA,sidaB,sidaC;

    public double area() {
        return 0;
    }

    public double perimeter() {
        return sidaA+sidaB+sidaC;
    }
}
