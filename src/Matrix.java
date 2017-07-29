import java.util.ArrayList;
import java.util.Arrays;

/**
 * author: Alexander Fal (falalexandr007@gmail.com)
 */
public class Matrix <T extends Number> {
    private ArrayList<ArrayList<T>> matrix;
    private int rows, cols;

    public Matrix(ArrayList<ArrayList<T>> matrix) {
        int length = matrix.get(0).size();
        for(ArrayList<T> aMatrix : matrix)
            if(aMatrix.size() != length)
                throw new IllegalArgumentException("Rows can't have different length");

        this.matrix = new ArrayList<>(matrix);
        rows = this.matrix.size();
        cols = this.matrix.get(0).size();
    }

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

    public Matrix(int dimensions) {
        this.rows = this.cols = dimensions;
        this.matrix = new ArrayList<>(dimensions);

        for(int i = 0; i < dimensions; i++)
            this.matrix.add(new ArrayList<>(dimensions));
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new ArrayList<>(rows);

        for(int i = 0; i < rows; i++)
            this.matrix.add(new ArrayList<>(cols));
    }

    public T get(int i, int j) {
        if(i >= rows || j >= cols)
            throw new IndexOutOfBoundsException();
        if(i < 0 || j < 0)
            throw new IndexOutOfBoundsException();

        return this.matrix.get(i).get(j);
    }

    public void set(int i, int j, T val) {
        if(i >= rows || j >= cols)
            throw new IndexOutOfBoundsException();
        if(i < 0 || j < 0)
            throw new IndexOutOfBoundsException();

        this.matrix.get(i).set(j, val);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
