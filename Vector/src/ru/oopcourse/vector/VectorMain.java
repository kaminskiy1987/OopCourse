package ru.oopcourse.vector;

public class VectorMain {
    public static void main(String[] args) {
        double[] array1 = {1.0, 2.0, 3.0, 4.0};
        double[] array2 = {5.0, 2.0, 4.0, 1.0};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);

        System.out.println("vector1 = " + vector1);
        System.out.println("vector2 = " + vector2);
        System.out.println("vectorSize = " + vector1.getSize());
        System.out.println("String = " + vector1.toString());

        Vector vector3 = vector1.vectorSum(vector2);
        System.out.println("vector3 = " + vector3);

        Vector vector4 = vector1.vectorSubtraction(vector2);
        System.out.println("vector4 = " + vector4);

        vector3 = vector3.scalarMultiplication(10.0);
        System.out.println("vectorInMultiplication = " + vector3);

        System.out.println("vectorSum  = " + vector1.sumLength(vector2));
        System.out.println("vectorLength = " + vector1.vectorLength());
        System.out.println("vectorReversal = " + vector1.vectorReversal());
        System.out.println(vector1.equals(vector2));
        System.out.println(vector1.hashCode());
        System.out.println(vector2.hashCode());
    }
}