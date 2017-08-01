package main.utils;

import main.data.Matrix;
import main.data.arithmetic.Numeric;
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
        if(right.getElemType() != left.getElemType())
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.INCOPATIBLE_MATRIX_TYPE_EXCEPTION);

//        COMPLETED: Implement Numeric interface and primitive types wrapers to be able to generify arithmetic ops
        int rows = left.getRows(), cols = right.getCols();
        Matrix <T> result = Matrix.of(left.getElemType()).initZero(rows, cols);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result.set(i, j,  eval(left, right, i, j));

        return result;
    }

    private static <T extends Number> T eval(Matrix<T> left, Matrix<T> right, int i, int j) {
        Numeric<T> sum;
        int k;
        for(sum = left.getNumeric(i,0).mult(right.get(0,j)), k = 1; k < left.getCols(); k++)
            sum = sum.add(left.getNumeric(i,k).mult(right.get(k,j)).getVal());

        return sum.getVal();
    }

    public static <T extends Number> Matrix add (Matrix<T> left, Matrix<T> right) {
        if(left == null || right == null)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);
        if(left.getCols() != right.getCols() || left.getRows() != right.getRows())
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.WRONG_ADD_DIMENSIONS_MESSAGE);
        if(right.getElemType() != left.getElemType())
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.INCOPATIBLE_MATRIX_TYPE_EXCEPTION);

        int rows = left.getRows(), cols = right.getCols();
        Matrix <T> result = Matrix.of(left.getElemType()).initZero(rows, cols);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result.set(i, j,  left.getNumeric(i,j).add(right.get(i, j)).getVal());

        return result;
    }

    public static <T extends Number> Matrix sub (Matrix<T> left, Matrix<T> right) {
        if(left == null || right == null)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);
        if(left.getCols() != right.getCols() || left.getRows() != right.getRows())
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.WRONG_ADD_DIMENSIONS_MESSAGE);
        if(right.getElemType() != left.getElemType())
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.INCOPATIBLE_MATRIX_TYPE_EXCEPTION);

        int rows = left.getRows(), cols = right.getCols();
        Matrix <T> result = Matrix.of(left.getElemType()).initZero(rows, cols);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result.set(i, j,  left.getNumeric(i,j).sub(right.get(i, j)).getVal());

        return result;
    }

    public static <T extends Number> Matrix transpose (Matrix<T> matrix) {
        if(matrix == null)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);

        int rows = matrix.getRows(), cols = matrix.getCols();
        Matrix <T> result = Matrix.of(matrix.getElemType()).initZero(cols, rows);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result.set(j, i,  matrix.get(i,j));

        return result;
    }

    public static <T extends Number> Matrix mult(Matrix<T> matrix, T scalar) {
        if(matrix == null)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);

        int rows = matrix.getRows(), cols = matrix.getCols();
        Matrix <T> result = Matrix.of(matrix.getElemType()).initZero(rows, cols);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result.set(i, j,  matrix.getNumeric(i,j).mult(scalar).getVal());

        return result;
    }
}
