package ru.oopcourse.shapes;

import java.util.Arrays;

public class ShapesMain {
    public static void sortArray(Shapes[] shapes) {
        Arrays.sort(shapes, Shapes.AreaComparator);
    }

    public static void main(String[] args) {
        Shapes[] shapes = {new Shapes.Square(10),
                new Shapes.Triangle(10, 2, 5, 7, -5, -3),
                new Shapes.Rectangle(5, 5),
                new Shapes.Circle(30),
                new Shapes.Square(1000)};

        sortArray(shapes);

        System.out.println("Максимальная площадь " + Arrays.toString(shapes));
    }
}