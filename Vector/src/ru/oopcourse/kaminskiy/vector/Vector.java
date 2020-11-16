package ru.oopcourse.kaminskiy.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(size + "must be >= 0");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        this(vector.components);

        vector.components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException(array.length + "must be >= 0");
        }

        components = new double[array.length];

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException(size + "must be >= 0");
        }

        assert false;
        if (array.length < size) {
            components = Arrays.copyOf(components, getSize());
        } else {
            components = Arrays.copyOf(components, array.length);
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

    public double getComponents(int index) {
        if (index < 0 || index > components.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return components[index];
    }

    public void setComponents(int index, double value) {
        if (index > 0 || index < components.length) {
            components[index] = value;
        } else {
            components = Arrays.copyOf(components, index);
        }
    }

    public void add(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            vector.components = Arrays.copyOf(vector.components, vector.getSize());
        }

        double[] result = new double[vector.getSize()];

        for (int i = 0; i < vector.getSize(); i++) {
            result[i] = components[i] + vector.components[i];
        }

    }

    public void subtraction(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            vector.components = Arrays.copyOf(vector.components, vector.getSize());
        }

        double[] result = new double[vector.getSize()];

        for (int i = 0; i < vector.getSize(); i++) {
            result[i] = components[i] - vector.components[i];
        }
    }

    public void multiplyScalar(double scalar) {
        double[] result = new double[getSize()];

        for (int i = 0; i < components.length; i++) {
            result[i] = scalar * components[i];
        }
    }

    public void vectorReversal() {
        multiplyScalar(-1.0);
    }

    public double getVectorLength() {
        return components.length;
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
        if (vector1.getSize() < 0 || vector2.getSize() < 0) {
            throw new IllegalArgumentException(vector1.getSize() + "or" + vector2.getSize() + "must be >= 0");
        }

        Vector result = new Vector(vector1.getSize());

        vector2.add(vector1);

        return result;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1.getSize() < 0 || vector2.getSize() < 0) {
            throw new IllegalArgumentException(vector1.getSize() + "or" + vector2.getSize() + "must be >= 0");
        }

        Vector result = new Vector(vector1.getSize());

        result.subtraction(vector2);

        return result;
    }

    public static Vector getScalarProduct(Vector vector1, Vector vector2) {
        if (vector1.getSize() < 0 || vector2.getSize() < 0) {
            throw new IllegalArgumentException(vector1.getSize() + "or" + vector2.getSize() + "must be >= 0");
        }

        Vector result = new Vector(vector1.getSize());

        for (int i = 0; i < vector1.getSize(); i++) {
            result.components[i] += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}