package ru.oopcourse.shapes.kaminskiy;

public class Square implements Shapes {
    private final double sideLength;

    private static final String name = "Square";

    public Square(double sideLength) {
        this.sideLength = sideLength;
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
        return (4 * sideLength);
    }

    @Override
    public String getName() {
        return name;
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

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Square p = (Square) o;

        return sideLength == p.sideLength;
    }

    @Override
    public String toString() {
        return getName() + "(" + sideLength + ")";
    }

}
