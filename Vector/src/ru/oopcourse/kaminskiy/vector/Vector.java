package ru.oopcourse.kaminskiy.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size: " + size + " <= 0");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        this(vector.components);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("length: " + array.length + " = 0");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("size: " + size + " <= 0");
        }

        if (array.length < size) {
            components = Arrays.copyOf(components, components.length);
        } else {
            components = Arrays.copyOf(components, size);
        }

    }

    public int getSize() {
        return components.length;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (int i = 0; i < getSize(); i++) {
            stringBuilder.append(components[i]).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }

    public double getComponent(int index) {
        if (index > components.length) {
            throw new IndexOutOfBoundsException("index: " + index + " > components.length");
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index > components.length) {
            throw new IndexOutOfBoundsException("index: " + index + " > components.length");
        }

        components[index] = value;
    }


    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] + vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] - vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = scalar * components[i];
        }
    }

    public void getReversal() {
        multiplyByScalar(-1.0);
    }

    public int getLength() {
        return getSize();
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
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

        Vector v = (Vector) o;

        return Arrays.equals(components, v.components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        result.add(vector2);

        return result;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        result.subtract(vector2);

        return result;
    }

    public static int getScalarProduct(Vector vector1, Vector vector2) {
        double result = 0;

        for (int i = 0; i < vector1.components.length; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return (int) result;
    }
}