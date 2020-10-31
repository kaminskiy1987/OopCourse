package ru.oopcourse.kaminskiy.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int arraySize) {
        if (arraySize <= 0) {
            throw new IllegalArgumentException("arraySize must be > 0");
        }

        components = new double[arraySize];
    }

    public Vector(Vector vector) {
        vector.components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public Vector(double[] array) {
        int arraySize = array.length;
        components = new double[arraySize];

        System.arraycopy(array, 0, components, 0, arraySize);
    }

    public Vector(int arraySize, double[] array) {
        if (arraySize <= 0) {
            throw new IllegalArgumentException("arraySize must be > 0");
        }

        for (int i = 0; i <= arraySize; i++) {
            if (array.length < arraySize) {
                components = new double[arraySize];
            } else {
                assert false;
                components[i] = array[i];
            }
        }
    }

    public int getSize() {
        return this.components.length;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String commaWithSpace = ", ";
        String openingCurlyBrace = "{ ";

        stringBuilder.append(openingCurlyBrace);

        for (int i = 0; i < getSize(); i++) {
            stringBuilder.append(components[i]).append(commaWithSpace);
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).append("}");

        return stringBuilder.toString();
    }

    public double[] getSum(Vector vector) {
        if (this.getSize() != vector.getSize()) {
            throw new IllegalArgumentException("arraySize must be equal to vector.arraySize");
        }

        double[] result = new double[vector.getSize()];
        for (int i = 0; i < vector.getSize(); i++) {
            result[i] = this.components[i] + vector.components[i];
        }

        return result;
    }

    public double[] getSubtraction(Vector vector) {
        if (this.getSize() != vector.getSize()) {
            throw new IllegalArgumentException("arraySize must be equal to vector.arraySize");
        }

        double[] result = new double[vector.getSize()];

        for (int i = 0; i < vector.getSize(); i++) {
            result[i] = this.components[i] - vector.components[i];
        }

        return result;
    }

    public double[] getScalarMultiplication(Vector vector, double scalar) {
        double[] result = new double[vector.getSize()];

        for (int i = 0; i < vector.getSize(); i++) {
            result[i] = scalar * this.components[i];
        }

        return result;
    }

    public double getVectorLength(Vector vector) {
        int arraySize = vector.getSize();
        if (arraySize != vector.getSize()) {
            throw new IllegalArgumentException("arraySize must be equal to vector.arraySize");
        }

        double sum = 0.0;

        for (int i = 0; i < arraySize; i++) {
            sum += this.components[i] * vector.components[i];
        }
        return Math.sqrt(sum);
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + getSize();
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Vector p = (Vector) o;

        return ((Vector) o).getSize() == p.getSize() && Arrays.equals(components, p.components);
    }

    public static Vector getVectorSum(Vector vector1, Vector vector2) {
        Vector result;
        result = new Vector(vector1.getSize());
        for (int i = 0; i < vector1.getSize(); i++) {
            result.components[i] = vector1.components[i] + vector2.components[i];
        }

        return result;
    }

    public static Vector getVectorSubtraction(Vector vector1, Vector vector2) {
        Vector result;
        result = new Vector(vector1.getSize());
        for (int i = 0; i < vector1.getSize(); i++) {
            result.components[i] = vector1.components[i] - vector2.components[i];
        }

        return result;
    }

    public static Vector getVectorScalarMultiplication(Vector vector1, Vector vector2) {
        Vector result;
        result = new Vector(vector1.getSize());
        for (int i = 0; i < vector1.getSize(); i++) {
            result.components[i] += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}