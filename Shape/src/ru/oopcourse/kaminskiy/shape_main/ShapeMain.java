package ru.oopcourse.kaminskiy.shape_main;

import ru.oopcourse.kaminskiy.shape.*;

import java.util.Arrays;

public class ShapeMain {
    public static Shape getMaxAreaOfShape(Shape[] shapes) {
        AreaComparator areaComparator = new AreaComparator();
        Arrays.sort(shapes, areaComparator);

        return shapes[shapes.length - 1];
    }

    public static Shape getSecondValuePerimeterOfShape(Shape[] shapes) {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        Arrays.sort(shapes, perimeterComparator);

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(10),
                new Triangle(100, 200, 50, 70, -50, -30),
                new Rectangle(10, 25),
                new Circle(30),
                new Square(1000)
        };

        System.out.println("Фигура с максимальной площадью: " + getMaxAreaOfShape(shapes));
        System.out.println("Фигура со вторым по величине периметром: " + getSecondValuePerimeterOfShape(shapes));
    }
}