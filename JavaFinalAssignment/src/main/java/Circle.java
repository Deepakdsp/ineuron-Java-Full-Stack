//Defination :  Write a Java program that uses polymorphism by defining an interface called Shape
//with methods to calculate the area and perimeter of a shape. Then create classes
//that implement the Shape interface for different types of shapes, such as circles and
//triangles.
package main.java;


public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateShapeArea() {
        return Math.PI * radius * radius; // Calculate area of circle
    }
}


