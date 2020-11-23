package ru.oopcourse.kaminskiy.shape;

public class Square implements Shape {
    private final double sideLength;

    public static final String NAME = "Square";

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(sideLength);

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Square s = (Square) o;

        return sideLength == s.sideLength;
    }

    @Override
    public String toString() {
        return "{" + NAME + " sideLength: " + sideLength + "; area: " + getArea() + "; perimeter: " + getPerimeter() + "}";

    }
}