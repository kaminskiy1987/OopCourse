package ru.oopcourse.kaminskiy.matrix_main;

import ru.oopcourse.kaminskiy.matrix.Matrix;
import ru.oopcourse.kaminskiy.vector.Vector;

import java.util.Arrays;

public class MatrixMain {
    public static void main(String[] args) {
        double[][] data1 = {{0.0, 1.0, 2.0, 3.0},
                {6.0, 7.0, 8.0, 9.0}};

        double[][] data2 = {{1.0, 11.0, 12.0, 3.0},
                {2.0, 1.0, 18.0, 9.0}};

        double[] array1 = {2.0, 2.0, 2.0, 2.0};
        Vector vector1 = new Vector(array1);

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        System.out.println("matrix1= " + matrix1);
        System.out.println("matrix2= " + matrix2);

        System.out.println("Sum= " + Matrix.getSum(matrix1, matrix2));
        System.out.println("Difference= " + Matrix.getDifference(matrix1, matrix2));
        System.out.println("Multiply= " + Matrix.getMultiply(matrix1, matrix2));

        System.out.println("matrix1Size= " + matrix1.size());
        System.out.println("matrix1Row= " + matrix1.getRow());

        matrix1.setRow(1, matrix1);
        System.out.println("matrixSetRow= " + matrix1);

        System.out.println("matrix1Column= " + matrix1.getColumn());

        matrix1.setColumn(2, matrix1);
        System.out.println("matrixSetColumn= " + matrix1);

        System.out.println("getColumnVector= " + matrix1.getColumnVector(matrix1, 2));

        System.out.println("getRowVector= " + matrix1.getRowVector(matrix1, 1));

        System.out.println("multiplyInVector= " + Arrays.toString(matrix1.multiplyInVector(data1, array1)));

        System.out.println("matrix2Size= " + matrix2.size());

        System.out.println("matrix1Get= " + matrix1.get(0, 1));

        matrix1.set(0, 3, 22);
        System.out.println("matrix1Set= " + matrix1);

        matrix1.add(matrix2);
        System.out.println("matrix1Add= " + matrix1);

        matrix1.subtract(matrix2);
        System.out.println("matrix1Subtract= " + matrix1);

        matrix1.multiplyByScalar(10);
        System.out.println("matrixMultiplyByScalar= " + matrix1);

        System.out.println("matrix1Transpose= " + matrix1.transpose());

        System.out.println(matrix1.equals(matrix2));
        System.out.println(matrix1.hashCode());
        System.out.println(matrix2.hashCode());
    }
}