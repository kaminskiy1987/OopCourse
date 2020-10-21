package ru.oopcourse.shapes.kaminskiy;

import java.util.Comparator;

interface Shapes {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    String getName();

    Comparator<? super Shapes> AreaComparator = (Comparator<Shapes>) (o1, o2) -> (int) Double.compare(o2.getArea(), o1.getArea());

    Comparator<? super Shapes> PerimeterComparator = (Comparator<Shapes>) (o1, o2) -> (int) Double.compare(o2.getPerimeter(), o1.getPerimeter());
}