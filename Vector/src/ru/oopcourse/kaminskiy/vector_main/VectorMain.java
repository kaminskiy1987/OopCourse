package ru.oopcourse.kaminskiy.vector_main;

import ru.oopcourse.kaminskiy.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        double[] array1 = {1.0, 2.0, 3.0, 4.0};
        double[] array2 = {5.0, 2.0, 4.0, 1.0};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);

        System.out.println("vector1= " + vector1);
        System.out.println("vector2= " + vector2);
        System.out.println("vector1Size= " + vector1.getSize());
        System.out.println("vector2Size= " + vector2.getSize());

        System.out.println("component= " + vector1.getComponent(0));
        vector1.setComponent(0, 3.0);

        vector1.add(vector2);
        vector1.subtract(vector2);
        vector1.multiplyByScalar(10);
        vector1.reverse();

        System.out.println("sum= " + Vector.getSum(vector1, vector2));
        System.out.println("difference= " + Vector.getDifference(vector1, vector2));
        System.out.println("scalarProduct= " + Vector.getScalarProduct(vector1, vector2));
        System.out.println("length= " + vector1.getLength());

        System.out.println(vector1.equals(vector2));
        System.out.println(vector1.hashCode());
        System.out.println(vector2.hashCode());
    }
}