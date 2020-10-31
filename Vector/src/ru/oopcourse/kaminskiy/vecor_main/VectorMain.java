package ru.oopcourse.kaminskiy.vecor_main;

import ru.oopcourse.kaminskiy.vector.Vector;

import java.util.Arrays;

public class VectorMain {
    public static void main(String[] args) {
        double[] array1 = {1.0, 2.0, 3.0, 4.0};
        double[] array2 = {5.0, 2.0, 4.0, 1.0};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);

        System.out.println("vector1 = " + vector1);
        System.out.println("vector2 = " + vector2);
        System.out.println("vector1 = " + vector1.getSize());

        System.out.println("Sum = " + Arrays.toString(vector1.getSum(vector2)));

        System.out.println("Sub = " + Arrays.toString(vector2.getSubtraction(vector1)));

        System.out.println("scalar = " + Arrays.toString(vector1.getScalarMultiplication(vector1, 10)));
        System.out.println("revers = " + Arrays.toString(vector1.getScalarMultiplication(vector1, -1)));

        System.out.println("vector5 = " + Vector.getVectorSum(vector1, vector2));
        System.out.println("vector6 = " + Vector.getVectorSubtraction(vector1, vector2));
        System.out.println("vector7 = " + Vector.getVectorScalarMultiplication(vector1, vector2));
        System.out.println("length = " + vector1.getVectorLength(vector2));

        System.out.println(vector1.equals(vector2));
        System.out.println(vector1.hashCode());
        System.out.println(vector2.hashCode());
    }
}