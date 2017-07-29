package main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents basic matrix structure
 * @author Alexander Fal (falalexandr007@gmail.com)
 * @version 1.0
 */
public class Matrix <T extends Number> {
    private ArrayList<ArrayList<T>> matrix;
    private int rows, cols;

    /**
     * Constructs matrix from {@link ArrayList} of {@link ArrayList<T>}
     * @param matrix {@link ArrayList} from which to construct matrix
     */
    public Matrix(ArrayList<ArrayList<T>> matrix) {
        int length = matrix.get(0).size();
        for(ArrayList<T> aMatrix : matrix)
            if(aMatrix.size() != length)
                throw new IllegalArgumentException("Rows can't have different length");

        this.matrix = new ArrayList<>(matrix);
        rows = this.matrix.size();
        cols = this.matrix.get(0).size();
    }

    /**
     * Constructs matrix from two-dimensional array
     * @param matrix array from which to construct matrix
     */
    public Matrix(T[][] matrix) {
        this.matrix = new ArrayList<>(matrix.length);

        int length = matrix[0].length;
        for (T[] aMatrix : matrix) {
            if (aMatrix.length != length)
                throw new IllegalArgumentException("Rows can't have different length");

            this.matrix.add(new ArrayList<>(Arrays.asList(aMatrix)));
        }

        rows = this.matrix.size();
        cols = this.matrix.get(0).size();
    }

    /**
     * Constructs empty dimensions x dimensions square matrix
     * @param dimensions length of rows and columns
     */
    public Matrix(int dimensions) {
        this.rows = this.cols = dimensions;
        this.matrix = new ArrayList<>(dimensions);

        for(int i = 0; i < dimensions; i++)
            this.matrix.add(new ArrayList<>(dimensions));
    }

    /**
     * Constructs empty rows x cols matrix
     * @param rows number of rows
     * @param cols number of columns
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new ArrayList<>(rows);

        for(int i = 0; i < rows; i++)
            this.matrix.add(new ArrayList<>(cols));
    }

    /**
     * Returns element at i row, j column ( matrix[i][j] )
     * @param i row number
     * @param j column number
     * @return element at position [i][j]
     */
    public T get(int i, int j) {
        if(i >= rows || j >= cols)
            throw new IndexOutOfBoundsException();
        if(i < 0 || j < 0)
            throw new IndexOutOfBoundsException();

        return this.matrix.get(i).get(j);
    }

    /**
     * Sets element at i row, j column ( matrix[i][j] ) to val
     * @param i row number
     * @param j column number
     * @param val value to set
     */
    public void set(int i, int j, T val) {
        if(i >= rows || j >= cols)
            throw new IndexOutOfBoundsException();
        if(i < 0 || j < 0)
            throw new IndexOutOfBoundsException();

        this.matrix.get(i).set(j, val);
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
}
