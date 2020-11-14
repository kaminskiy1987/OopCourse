package ru.oopcourse.kaminskiy.shape;

public class Rectangle implements Shape {
    private final double height;
    private final double width;

    public static final String NAME_SHAPE = "Rectangle";

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String getName() {
        return NAME_SHAPE;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);

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

        Rectangle p = (Rectangle) o;

        return width == p.width && height == p.height;
    }

    @Override
    public String toString() {
        return "{" + NAME_SHAPE + " (" + "height: " + height + "; width: " + width + ")" + "}";
    }
}