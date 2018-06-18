package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Square extends Shape {

    private double size;

    public double area() {
        return size*size;
    }

    public double perimeter() {
        return size*4;
    }
}
