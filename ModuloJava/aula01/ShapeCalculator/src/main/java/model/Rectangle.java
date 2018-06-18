package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rectangle extends Shape {

    private double base,height;

    public double area() {
        return base*height;
    }

    public double perimeter() {
        return (base*2)+(height+2);
    }
}
