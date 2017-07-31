package main.data;

import main.data.arithmetic.*;
import main.data.exceptions.BadIndexException;
import main.data.exceptions.MatrixIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents basic matrix object.
 * @author Alexander Fal (falalexandr007@gmail.com)
 * @version 1.0
 */
public class Matrix <T extends Number> {
    private ArrayList< ArrayList< Numeric< T > > > matrix;
    private int rows, cols;

    /**
     * Constructs matrix from {@link ArrayList} of {@link ArrayList<T>}
     * @param matrix {@link ArrayList} from which to construct matrix
     * @throws MatrixIllegalArgumentException if rows in {@link ArrayList} have different length or {@code matrix == null}
     */
    public Matrix(ArrayList<ArrayList<T>> matrix) {
        if(matrix == null)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);

        int length = matrix.get(0).size();
        for(ArrayList<T> aMatrix : matrix)
            if(aMatrix.size() != length)
                throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.DIFFERENT_ROWS_LENGTH_MESSAGE);

        this.matrix = new ArrayList<>();
        int size = matrix.size();
        for(int i = 0; i < size; i++) {
            this.matrix.add(new ArrayList<>());
            ArrayList<Numeric<T>> new_row = this.matrix.get(i);
            for(T val : matrix.get(i))
                addVal(new_row, val);
        }

        rows = this.matrix.size();
        cols = this.matrix.get(0).size();
    }

//    TODO: Abstract Fabric ?????
    @SuppressWarnings("unchecked")
    private void addVal(ArrayList<Numeric<T>> new_row, T val) {
        switch (val.getClass().getSimpleName().toLowerCase()) {
            case "long":
                new_row.add((Numeric<T>) new RichLong((Long) val));
                break;
            case "integer":
            case "int":
                new_row.add((Numeric<T>) new RichInt((Integer) val));
                break;
            case "short":
                new_row.add((Numeric<T>) new RichShort((Short) val));
                break;
            case "float":
                new_row.add((Numeric<T>) new RichFloat((Float) val));
                break;
            case "double":
                new_row.add((Numeric<T>) new RichDouble((Double) val));
                break;
        }
    }

    /**
     * Constructs matrix from two-dimensional array
     * @param matrix array from which to construct matrix
     * @throws MatrixIllegalArgumentException if rows in array have different length or {@code matrix == null}
     */
    public Matrix(T[][] matrix) {
        if(matrix == null)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);

        this.matrix = new ArrayList<>(matrix.length);

        int length = matrix[0].length;
        for (int i = 0; i < length; i++) {
            if (matrix[i].length != length)
                throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.DIFFERENT_ROWS_LENGTH_MESSAGE);

            this.matrix.add(new ArrayList<>());
            ArrayList<Numeric<T>> new_row = this.matrix.get(i);
            for(T val : matrix[i])
                addVal(new_row, val);
        }

        rows = matrix.length;
        cols = matrix[0].length;
    }

    /**
     * Constructs dimensions x dimensions square matrix filled with zeros
     * @param dimensions length of rows and columns; must be greater than 2
     * @throws MatrixIllegalArgumentException if {@code dimensions < 2}
     */
    public Matrix(int dimensions) {
        if(dimensions < 2)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.WRONG_DIMENSIONS_NUMBER_MESSAGE);

        rows = cols = dimensions;
        matrix = new ArrayList<>(dimensions);

        for(int i = 0; i < dimensions; i++) {
            matrix.add(new ArrayList<>(dimensions));

            ArrayList<Numeric<T>> row = matrix.get(i);
            for(int j = 0; j < dimensions; j++)
                row.add(null);
        }
    }

    /**
     * Constructs rows x cols matrix filled with zeros
     * @param rows number of rows; must be greater than 2
     * @param cols number of columns; must be greater than 2
     * @throws MatrixIllegalArgumentException if {@code rows < 2 || cols < 2}
     */
    public Matrix(int rows, int cols) {
        if(rows < 2)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.WRONG_ROWS_NUMBER_MESSAGE);
        if(cols < 2)
            throw new MatrixIllegalArgumentException(MatrixIllegalArgumentException.WRONG_COLUMNS_NUMBER_MESSAGE);

        this.rows = rows;
        this.cols = cols;
        matrix = new ArrayList<>(rows);

        for(int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>(cols));

            ArrayList<Numeric<T>> row = matrix.get(i);
            for(int j = 0; j < cols; j++)
                row.add(null);
        }
    }

    /**
     * Returns element at i row, j column ( matrix[i][j] )
     * @param i row number
     * @param j column number
     * @return element at position [i][j]
     * @throws BadIndexException if {@code i >= this.rows || i < 0 || j >= this.cols || j < 0}
     */
    public T get(int i, int j) {
        if(i >= rows || j >= cols)
            throw new BadIndexException(BadIndexException.INDEX_OUT_OF_BOUNDS_MESSAGE);
        if(i < 0 || j < 0)
            throw new BadIndexException(BadIndexException.NEGATIVE_INDEX_MESSAGE);

        Numeric<T> ret = matrix.get(i).get(j);

        return ret == null ? (T) Integer.valueOf(0) : ret.getVal();
    }

    public Numeric<T> getNumeric(int i, int j) {
        if(i >= rows || j >= cols)
            throw new BadIndexException(BadIndexException.INDEX_OUT_OF_BOUNDS_MESSAGE);
        if(i < 0 || j < 0)
            throw new BadIndexException(BadIndexException.NEGATIVE_INDEX_MESSAGE);

        return matrix.get(i).get(j);
    }

    /**
     * Sets element at i row, j column ( matrix[i][j] ) to val
     * @param i row number
     * @param j column number
     * @param val value to set
     * @throws BadIndexException if {@code i >= this.rows || i < 0 || j >= this.cols || j < 0}
     */
    @SuppressWarnings("unchecked")
    public void set(int i, int j, T val) {
        if(i >= rows || j >= cols)
            throw new BadIndexException(BadIndexException.INDEX_OUT_OF_BOUNDS_MESSAGE);
        if(i < 0 || j < 0)
            throw new BadIndexException(BadIndexException.NEGATIVE_INDEX_MESSAGE);

        switch(val.getClass().getSimpleName().toLowerCase()) {
            case "long":
                matrix.get(i).set(j, (Numeric<T>) new RichLong((Long) val));
                break;
            case "integer":
            case "int":
                matrix.get(i).set(j, (Numeric<T>) new RichInt((Integer) val));
                break;
            case "short":
                matrix.get(i).set(j, (Numeric<T>) new RichShort((Short) val));
                break;
            case "float":
                matrix.get(i).set(j, (Numeric<T>) new RichFloat((Float) val));
                break;
            case "double":
                matrix.get(i).set(j, (Numeric<T>) new RichDouble((Double) val));
                break;
        }
    }

    /**
     * Returns number of rows in matrix
     * @return number of rows in matrix
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns number of columns in matrix
     * @return number of columns in matrix
     */
    public int getCols() {
        return cols;
    }

    /**
     * Add all values to matrix starting from [0][0].
     * Left to right, top to bottom.
     * First {@code cols * rows} values are added, all extra values are ignored.
     * @param values values to be added
     * @return {@link Matrix} filled with specified values
     */
    @SafeVarargs
    public final Matrix addAll(T... values) {
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                try {
                    set(i, j, values[cols * i + j]);
                } catch (IndexOutOfBoundsException e) {
                    return this;
                }

        return this;
    }
}
