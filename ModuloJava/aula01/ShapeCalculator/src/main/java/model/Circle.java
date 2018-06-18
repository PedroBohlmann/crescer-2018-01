package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Circle extends Shape {

    private double radius;

    public double area() {
        return Math.PI*(Math.pow(radius,2));
    }

    public double perimeter() {
        return 2*Math.PI*radius;
    }
}
