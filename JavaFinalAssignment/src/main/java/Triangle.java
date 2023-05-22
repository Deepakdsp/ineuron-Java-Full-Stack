package main.java;

public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Double calculateShapeArea() {
        return 0.5 * base * height; // Calculate area of triangle
    }
}
