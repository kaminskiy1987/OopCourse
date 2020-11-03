package ru.oopcourse.kaminskiy.shape_main.ShapeMain;

import ru.oopcourse.kaminskiy.shape.Shape.Shape;

import java.util.Comparator;

public class AreaComparator {
    public static Comparator<? super Shape> AreaComparator = (Comparator<Shape>) (s1, s2) -> (int) Double.compare(s2.getArea(), s1.getArea());
}