package ru.oopcourse.kaminskiy.shape_main.ShapeMain;

import ru.oopcourse.kaminskiy.shape.Shape.*;

import java.util.Arrays;

public class ShapeMain {
    public static Shape getMaxArray(Shape[] shapes) {
        Arrays.sort(shapes, AreaComparator.AreaComparator);

        return shapes[0];
    }

    public static Shape getPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, PerimeterComparator.PerimeterComparator);

        return shapes[1];
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Square(10),
                new Triangle(10, 2, 5, 7, -5, -3),
                new Rectangle(10, 25),
                new Circle(30),
                new Square(1000)};

        getMaxArray(shapes);
        getPerimeter(shapes);

        System.out.println("Максимальная площадь " + getMaxArray(shapes));
        System.out.println("Второй по величине периметр " + getPerimeter(shapes));
    }
}
