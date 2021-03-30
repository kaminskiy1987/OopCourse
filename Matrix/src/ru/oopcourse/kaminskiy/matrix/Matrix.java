package ru.oopcourse.kaminskiy.matrix;

import ru.oopcourse.kaminskiy.vector.Vector;

public class Matrix {
    private final double[][] data;
    private final int column;
    private final int row;

    public Matrix(int column, int row) {
        this.column = column;
        this.row = row;
        data = new double[row][column];
    }

    public Matrix(double[][] data) {
        this.data = data;
        this.row = data.length;
        this.column = (row > 0) ? data[0].length : 0;
    }

    public Matrix(double[] vector) {
        if (vector.length == 0) {
            throw new IllegalArgumentException("length: " + vector.length + " = 0");
        }

        this.data = new double[vector.length][1];
        this.column = vector.length;
        this.row = 1;

        for (int i = 0; i < vector.length; i++) {
            this.data[i][0] = vector[i];
        }
    }

    public Matrix(Matrix matrix) {
        Matrix clone = (Matrix) matrix.getClone();
        this.data = clone.data;
        row = clone.row;
        column = clone.column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row, Matrix matrix) {
        if (column >= 0) System.arraycopy(matrix.data[0], 0, data[row], 0, column);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column, Matrix matrix) {
        for (int i = 0; i < row; i++) {
            data[i][column] = matrix.data[i][0];
        }
    }

    public int size() {
        return row * column;
    }

    public double get(int row, int column) {
        return data[row][column];
    }

    public void set(int row, int column, double value) {
        data[row][column] = value;
    }

    public Vector getRowVector(Matrix matrix, int row) {
        return new Vector(matrix.data[row]);
    }

    public Matrix setRowVector(Matrix matrix, int row, double[] vector) {
        int length = (int) Math.min(matrix.data[row].length, vector.length);

        Matrix matrix1 = new Matrix(row, column);

        System.arraycopy(vector, 0, matrix1.data[row], 0, length);

        return matrix1;
    }

    public Vector getColumnVector(Matrix matrix, int column) {
        double[] columnVector = new double[matrix.data.length];

        for (int row = 0; row < matrix.data.length; row++) {
            columnVector[row] = matrix.data[row][column];
        }

        return new Vector(columnVector);
    }

    public Matrix setColumnVector(Matrix matrix, int column, double[] vector) {
        int length = (int) Math.min(matrix.data.length, vector.length);

        Matrix matrix1 = new Matrix(row, column);

        System.arraycopy(vector, 0, matrix1.data[row], 0, length);

        return matrix1;
    }

    public double[] multiplyInVector(double[][] data, double[] vector) {
        int rows = data.length;
        int columns = data[0].length;

        double[] result = new double[rows];

        for (int row = 0; row < rows; row++) {
            double sum = 0;

            for (int column = 0; column < columns; column++) {
                sum += data[row][column] * vector[column];
            }

            result[row] = sum;
        }

        return result;
    }

    public Object getClone() {
        Matrix clone = new Matrix(row, column);

        System.arraycopy(data, 0, clone.data, 0, row * column);

        return clone;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < row; i++) {
            stringBuilder.append("{");

            for (int j = 0; j < column; j++) {
                stringBuilder.append(get(i, j));

                if (j != column - 1) {
                    stringBuilder.append(", ");
                }
            }

            stringBuilder.append("}");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("}");

        return stringBuilder.toString();
    }

    public double determinant(Matrix matrix) {
        if (matrix.column == 1) {
            return matrix.data[0][0];
        } else if (matrix.column == 2) {
            return (matrix.data[0][0] * matrix.data[1][1] - matrix.data[0][1] * matrix.data[1][0]);
        } else {
            double result = 0;

            for (int i = 0; i < matrix.column; i++) {
                Matrix subMatrix = subMatrix(matrix, 1, i + 1);

                result += (Math.pow(-1, 1 + i + 1) * matrix.data[0][i] * determinant(subMatrix));
            }

            return result;
        }
    }

    public static Matrix subMatrix(Matrix matrix, int c, int r) {
        Matrix result = new Matrix(matrix.column - 1, matrix.row - 1);

        for (int rows = 0, i = 0; rows < matrix.row; rows++) {
            if (rows != r - 1) {
                for (int cols = 0, j = 0; cols < matrix.column; cols++) {
                    if (cols != c) {
                        result.data[i][j] = matrix.data[rows][cols];

                        j++;
                    }
                }

                i++;
            }
        }

        return result;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] *= scalar;
            }
        }
    }

    public Matrix transpose() {
        Matrix result = new Matrix(row, column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.data[j][i] = data[i][j];
            }
        }

        return result;
    }

    public void add(Matrix matrix) {
        int matrixRow = Math.min(matrix.row, row);
        int matrixColumn = Math.min(matrix.column, column);

        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixColumn; j++) {
                data[i][j] += matrix.data[i][j];
            }
        }
    }

    public void subtract(Matrix matrix) {
        int matrixRow = Math.min(matrix.row, row);
        int matrixColumn = Math.min(matrix.column, column);

        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixColumn; j++) {
                data[i][j] -= matrix.data[i][j];
            }
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1.row, matrix1.column);

        result.add(matrix2);

        return result;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1.row, matrix1.column);

        result.subtract(matrix2);

        return result;
    }

    public static Matrix getMultiply(Matrix matrix1, Matrix matrix2) {
        int matrixRow = Math.min(matrix1.row, matrix2.row);
        int matrixColumn = Math.min(matrix1.column, matrix2.column);

        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixColumn; j++) {
                matrix1.data[i][j] *= matrix2.data[i][j];
            }
        }

        return matrix1;
    }
}