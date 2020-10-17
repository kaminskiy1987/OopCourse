package ru.oopcourse.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] componentsArray;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        this.n = n;
        componentsArray = new double[n];
    }

    public Vector(Vector vector) {
        this(vector.n, vector.componentsArray);
    }

    public Vector(double[] array) {
        n = array.length;
        componentsArray = new double[n];

        for (int i = 0; i < n; i++) {
            componentsArray[i] = array[i];
        }
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        componentsArray = new double[n];

        for (int i = 0; i <= n; i++) {
            if (array.length < n) {
                componentsArray = new double[n];
            } else {
                componentsArray[i] = array[i];
            }
        }
    }

    public int getSize() {
        return n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String commaSpace = ", ";
        String q = "{";

        for (int i = 0; i < n; i++) {
            stringBuilder.append(componentsArray[i]).append(commaSpace);
        }

        stringBuilder.insert(0, '{').deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }

    public Vector vectorSum(Vector vector) {
        if (this.n != vector.n) {
            throw new IllegalArgumentException();
        }

        Vector vectorInstance = new Vector(n);

        for (int i = 0; i < n; i++) {
            vectorInstance.componentsArray[i] = this.componentsArray[i] + vector.componentsArray[i];
        }

        return vectorInstance;
    }

    public Vector vectorSubtraction(Vector vector) {
        if (this.n != vector.n) {
            throw new IllegalArgumentException();
        }

        Vector vectorInstance = new Vector(n);

        for (int i = 0; i < n; i++) {
            vectorInstance.componentsArray[i] = this.componentsArray[i] - vector.componentsArray[i];
        }

        return vectorInstance;
    }

    public Vector scalarMultiplication(double scalar) {
        Vector vectorInstance = new Vector(n);

        for (int i = 0; i < n; i++) {
            vectorInstance.componentsArray[i] = scalar * componentsArray[i];
        }

        return vectorInstance;
    }

    public Vector vectorReversal() {
        Vector vectorInstance = new Vector(n);

        for (int i = 0; i < n; i++) {
            vectorInstance.componentsArray[i] = (-1) * componentsArray[i];
        }

        return vectorInstance;
    }

    public double sumLength(Vector vector) {
        if (this.n != vector.n) {
            throw new IllegalArgumentException();
        }

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += (this.componentsArray[i] * vector.componentsArray[i]);
        }

        return sum;
    }

    public double vectorLength() {
        return Math.sqrt(this.sumLength(this));
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + n;
        hash = prime * hash + Arrays.hashCode(componentsArray);
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

        return n == p.n && Arrays.equals(componentsArray, p.componentsArray);
    }

    public static Vector staticVectorSum(Vector v, Vector r) {
        return v.vectorSum(r);
    }

    public static Vector staticVectorSubtraction(Vector v, Vector r) {
        return v.vectorSubtraction(r);
    }

    public static double getVectorSum(double[] array1, double[] array2) {
        double res = 0.0;
        int i = 0;

        for (double n : array1) {
            res += n * array2[i];
            i++;
        }
        return res;
    }
}