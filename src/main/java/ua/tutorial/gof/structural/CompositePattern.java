package ua.tutorial.gof.structural;

import java.util.ArrayList;
import java.util.List;

// https://refactoring.guru/design-patterns/composite
public class CompositePattern {
    public static void main(String[] args) {
        Composite rootShape = new Composite();
        rootShape.addShape(new Triangle());
        rootShape.addShape(new Circle());
        rootShape.addShape(new Square());

        Composite nextShapeLevel = new Composite();
        rootShape.addShape(nextShapeLevel);
        nextShapeLevel.addShape(new Triangle());
        nextShapeLevel.addShape(new Circle());
        nextShapeLevel.addShape(new Square());

        rootShape.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}

class Composite implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void deleteShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        System.out.println("Composite");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}