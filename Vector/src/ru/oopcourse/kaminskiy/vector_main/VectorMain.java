package ru.oopcourse.kaminskiy.vector_main;

import ru.oopcourse.kaminskiy.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        double[] array1 = {1.0, 2.0, 3.0, 4.0};
        double[] array2 = {5.0, 2.0, 4.0, 1.0};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);

        System.out.println("vector1 = " + vector1);
        System.out.println("vector2 = " + vector2);
        System.out.println("vector1 = " + vector1.getSize());

        vector1.add(vector2);
        vector1.subtraction(vector2);
        vector1.multiplyScalar(10);
        vector1.vectorReversal();

        System.out.println("vector5  = " + vector1.getComponents(2));
        vector1.setComponents(2, 5.0);

        System.out.println("vector5  = " + Vector.getSum(vector1, vector2));
        System.out.println("vector6  = " + Vector.getDifference(vector1, vector2));
        System.out.println("vector7  = " + Vector.getScalarProduct(vector1, vector2));
        System.out.println("length = " + vector1.getVectorLength());

        System.out.println(vector1.equals(vector2));
        System.out.println(vector1.hashCode());
        System.out.println(vector2.hashCode());
    }
}