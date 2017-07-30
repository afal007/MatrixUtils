package main.utils;

import main.data.Matrix;
import main.data.exceptions.MatrixIllegalArgumentException;

/**
 * Basic matrix operations
 * @author Alexander Fal
 * @version 1.0
 */
public class MatrixUtils {
    /**
     * Matrix multiplication
     * @param left left-hand matrix
     * @param right right-hand matrix
     * @param <T> type of matrix elements
     * @return resulting matrix after multiplication
     * @throws MatrixIllegalArgumentException if {@code left == null || right == null} or
     *                                           {@code left.getCols() != right.getRows()}
     */
    public static <T extends Number> Matrix mult (Matrix<T> left, Matrix<T> right) {
        if(left == null || right == null)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);
        if(left.getCols() != right.getRows())
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.WRONG_MULT_DIMENSIONS_MESSAGE);

//        TODO: Implement Numeric interface and primitive numbers wrapers to be able to generify arithmetic ops
        int rows = left.getRows(), cols = right.getCols();
        Matrix <T> result = new Matrix<>(rows, cols);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result.set(i, j,  eval(left, right, i, j));

        return result;
    }

    private static <T extends Number> T eval(Matrix<T> left, Matrix<T> right, int i, int j) {
        return (T) Integer.valueOf(0);
    }

    public <T extends Number> Matrix add (Matrix<T> left, Matrix<T> right) {
        return new Matrix<>(new Integer[][]{{1, 2}, {3, 4}});
    }

    public <T extends Number> Matrix sub (Matrix<T> left, Matrix<T> right) {
        return new Matrix<>(new Integer[][]{{1, 2}, {3, 4}});
    }

    public <T extends Number> Matrix transpose (Matrix<T> matrix) {
        return new Matrix<>(new Integer[][]{{1, 2}, {3, 4}});
    }

    public <T extends Number> Matrix mult(Matrix<T> matrix, int scalar) {
        return new Matrix<>(new Integer[][]{{1, 2}, {3, 4}});
    }
}
