package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Triangle extends Shape {

    private double sideA, sideB, sideC;

    public double area() {
        double semiPerimeter = (sideA+sideB+sideC)/2;
        return Math.sqrt(semiPerimeter*(semiPerimeter-sideA)*(semiPerimeter-sideB)*(semiPerimeter-sideC));
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }
}
