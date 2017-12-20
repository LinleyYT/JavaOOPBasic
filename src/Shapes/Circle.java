package Shapes;

import org.omg.CORBA.MARSHAL;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;

        this.calculateArea();
        this.calculatePerimeter();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.radius * 3.14 * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.radius * this.radius * 3.14);
    }

    public final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

}
