package ru.oopcourse.kaminskiy.shape_main;

import ru.oopcourse.kaminskiy.shape.*;

import java.util.Arrays;

public class ShapeMain {
    public static Shape getShapeWithMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());

        if (shapes.length == 0) {
            return null;
        }

        return shapes[shapes.length - 1];
    }

    public static Shape getShapeWithSecondValuePerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());

        if (shapes.length == 0) {
            return null;
        }

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(10),
                new Triangle(100, 200, 50, 70, -50, -30),
                new Rectangle(100, 250),
                new Circle(30),
                new Square(1000)
        };

        System.out.println("Параметры фигур : " + Arrays.toString(shapes));
        System.out.println("Фигура с максимальной площадью: " + getShapeWithMaxArea(shapes));
        System.out.println("Фигура со вторым по величине периметром: " + getShapeWithSecondValuePerimeter(shapes));
    }
}