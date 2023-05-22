package main.java;

import main.java.Circle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        System.out.println("Area of Circle: " + circle.calculateShapeArea());
        Triangle triangle = new Triangle(5, 9);
        System.out.println("Area of Triangle: " + triangle.calculateShapeArea());
    }
}