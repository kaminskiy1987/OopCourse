package ru.oopcourse.shapes;

import java.util.Arrays;
import java.util.Comparator;

interface Shapes {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    String getName();

    class Square implements Shapes {
        double sideLength;

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
    }

    class Triangle implements Shapes {
        double x1;
        double y1;
        double x2;
        double y2;
        double x3;
        double y3;

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

        @Override
        public double getArea() {
            double epsilon = 1.0e-10;

            if (Math.abs((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1)) <= epsilon) {
                return 0;
            } else {
                double sideLength1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                double sideLength2 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
                double sideLength3 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

                double triangleHalfPerimeter = (sideLength1 + sideLength2 + sideLength3) / 2;

                return Math.sqrt(triangleHalfPerimeter * (triangleHalfPerimeter - sideLength1) * (triangleHalfPerimeter - sideLength2) * (triangleHalfPerimeter - sideLength3));
            }
        }

        @Override
        public double getPerimeter() {
            double epsilon = 1.0e-10;

            if (Math.abs((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1)) <= epsilon) {
                return 0;
            } else {
                double sideLength1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                double sideLength2 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
                double sideLength3 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

                return sideLength1 + sideLength2 + sideLength3;
            }
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

            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }

            Triangle p = (Triangle) o;

            return x1 == p.x1 && x2 == p.x2 && x3 == p.x3 && y1 == p.y1 && y2 == p.y2 && y3 == p.y3;
        }
    }

    class Rectangle implements Shapes {
        double height;
        double width;

        private static final String name = "Rectangle";

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
            return name;
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

            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }

            Rectangle p = (Rectangle) o;

            return width == p.width && height == p.height;
        }
    }

    class Circle implements Shapes {
        double radius;

        private static final String name = "Circle";

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getWidth() {
            return 2 * radius;
        }

        @Override
        public double getHeight() {
            return 2 * radius;
        }

        @Override
        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String getName() {
            return name;
        }

        public int hashCode() {
            final int prime = 37;
            int hash = 1;
            hash = prime * hash + Double.hashCode(radius);
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

            Circle p = (Circle) o;

            return radius == p.radius;
        }
    }

    public static Comparator<? super Shapes> AreaComparator = new Comparator<Shapes>() {
        @Override
        public int compare(Shapes o1, Shapes o2) {
            return (int) (o1.getArea() - o2.getArea());
        }
    };
}