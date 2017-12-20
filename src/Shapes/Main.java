package Shapes;

import sun.security.provider.SHA;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(8D);
        Shape rect = new Rectangle(4D, 2D);

        List<Shape> shapes= new LinkedList<>();
        shapes.add(circle);
        shapes.add(rect);

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            System.out.println(shape.getPerimeter());
            System.out.println();
        }
    }
}
