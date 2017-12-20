package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public final Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public final Double getArea() {
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();


}
