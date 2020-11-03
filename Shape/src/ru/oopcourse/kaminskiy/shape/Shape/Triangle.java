package ru.oopcourse.kaminskiy.shape.Shape;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    private static final String name = "Triangle";

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double[] getSidesLengths() {
        return new double[]{Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)),
                Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)),
                Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2))};
    }

    @Override
    public double getArea() {
        double[] sidesLengths = getSidesLengths();

        double triangleHalfPerimeter = getPerimeter() / 2;

        return Math.sqrt(triangleHalfPerimeter * (triangleHalfPerimeter - sidesLengths[0]) * (triangleHalfPerimeter - sidesLengths[1]) * (triangleHalfPerimeter - sidesLengths[2]));
    }

    @Override
    public double getPerimeter() {
        double[] sidesLengths = getSidesLengths();

        return sidesLengths[0] + sidesLengths[1] + sidesLengths[2];
    }

    @Override
    public String getName() {
        return name;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);

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

        Triangle t = (Triangle) o;

        return x1 == t.x1 && x2 == t.x2 && x3 == t.x3 && y1 == t.y1 && y2 == t.y2 && y3 == t.y3;
    }

    @Override
    public String toString() {
        return name + "A(" + x1 + "; " + y1 + "), B(" + x2 + "; " + y2 + "), C(" + x3 + "; " + y3 + ")";
    }
}