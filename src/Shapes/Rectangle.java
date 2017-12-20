package Shapes;

import com.sun.org.apache.regexp.internal.RE;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.width = width;
        this.height = height;

        this.calculateArea();
        this.calculatePerimeter();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * this.height + 2 * this.width);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.height * this.width);
    }

    public final Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public final Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

}
