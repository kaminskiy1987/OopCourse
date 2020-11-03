package ru.oopcourse.kaminskiy.shape_main.ShapeMain;

import ru.oopcourse.kaminskiy.shape.Shape.Shape;

import java.util.Comparator;

public class PerimeterComparator {
    public static Comparator<? super Shape> PerimeterComparator = (Comparator<Shape>) (s1, s2) -> (int) Double.compare(s2.getPerimeter(), s1.getPerimeter());
}
