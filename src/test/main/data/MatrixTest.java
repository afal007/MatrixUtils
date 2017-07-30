package test.main.data;

import main.data.Matrix;
import main.data.exceptions.BadIndexException;
import main.data.exceptions.MatrixIllegalArgumentException;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Feature: testing methods from Matrix class
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
class MatrixTest {
    private static Matrix<Integer> matrix;
    private static final int dimensions = 2;
    @BeforeAll
    static void beforeAll() {
        matrix = new Matrix<>(dimensions);
    }

    /**
     * Feature: testing Matrix object creation
     * @author Alexander Fal (falalexandr007@gmail.com)
     */
    @Nested
    @DisplayName("Constructors")
    class ConstructorsTests {

        /**
         * Create matrix from {@link ArrayList}
         * 1. Create {@link ArrayList}
         * 2. Create {@link Matrix} from {@link ArrayList}
         *  a. check if each element in {@link Matrix} equals to corresponding element in {@link ArrayList}
         * @throws MatrixIllegalArgumentException if rows in {@link ArrayList} have different length or {@code array == null}
         */
        @Test
        void testCreateMatrixFromArrayList() {
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

            int rows = 3, cols = 4;
            for(int i = 0; i < rows; i++) {
                arr.add(new ArrayList<>());
                ArrayList<Integer> row = arr.get(i);
                for(int j = 0; j < cols; j++)
                    row.add(j);
            }

            Matrix<Integer> matrix = new Matrix<>(arr);
            for(int i = 0; i < rows; i++) {
                ArrayList<Integer> row = arr.get(i);
                for (int j = 0; j < cols; j++)
                    assertEquals(matrix.get(i, j), row.get(j));
            }
        }

        /**
         * Create matrix from {@link ArrayList}
         * 1. Create {@link ArrayList} reference and assign null
         * 2. Create {@link Matrix} from {@link ArrayList}
         *  a. check if exception with correct message was thrown
         * @throws MatrixIllegalArgumentException if rows in {@link ArrayList} have different length or {@code array == null}
         */
        @Test
        void testCreateMatrixFromArrayListNull() {
            ArrayList<ArrayList<Integer>> arr = null;

            MatrixIllegalArgumentException exception = assertThrows(MatrixIllegalArgumentException.class, () -> new Matrix<>(arr));
            assertEquals(exception.getMessage(), MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);
        }

        /**
         * Create matrix from two-dimensional array
         * 1. Create {@link ArrayList}
         * 2. Create {@link Matrix} from {@link ArrayList}
         *  a. check if each element in {@link Matrix} equals to corresponding element in {@link ArrayList}
         * @throws MatrixIllegalArgumentException if rows in {@link ArrayList} have different length or {@code array == null}
         */
        @Test
        void testCreateMatrixFromArray() {
            int rows = 4, cols = 3;
            Integer[][] arr = new Integer[rows][cols];
            for(int i = 0; i < rows; i++)
                for(int j = 0; j < cols; j++)
                    arr[i][j] = i;

            Matrix<Integer> matrix = new Matrix<> (arr);
            for(int i = 0; i < rows; i++)
                for(int j = 0; j < cols; j++)
                    assertEquals(matrix.get(i,j), arr[i][j]);
        }

        /**
         * Create matrix from null-reference to two-dimensional array
         * 1. Create array reference and assign null
         * 2. Create {@link Matrix} from array
         *  a. check if exception with correct message was thrown
         * @throws MatrixIllegalArgumentException if rows in array have different length or {@code array == null}
         */
        @Test
        void testCreateMatrixFromArrayNull() {
            Integer[][] arr = null;

            MatrixIllegalArgumentException exception = assertThrows(MatrixIllegalArgumentException.class, () -> new Matrix<>(arr));
            assertEquals(exception.getMessage(), MatrixIllegalArgumentException.ARGUMENT_CANT_BE_NULL_MESSAGE);
        }

        /**
         * Create square matrix filled with zeros
         * 1. Create matrix with valid dimensions argument
         * @throws MatrixIllegalArgumentException if {@code dimensions < 2}
         */
        @Test
        void testCreateZeroSquareMatrix() {
            new Matrix<Integer>(2);
        }

        /**
         * Create square matrix with wrong dimensions
         * 1. Create matrix with {@code dimensions < 2}
         *  a. check that exception with correct error message was thrown
         * @throws MatrixIllegalArgumentException if {@code dimensions < 2}
         */
        @Test
        void testCreateZeroSquareMatrixBadDimensions() {
            Exception exception = assertThrows(MatrixIllegalArgumentException.class, () -> new Matrix<Integer>(1));
            assertEquals(exception.getMessage(), MatrixIllegalArgumentException.WRONG_DIMENSIONS_NUMBER_MESSAGE);
        }

        /**
         * Create matrix filled with zeros
         * 1. Create matrix with valid rows and cols arguments
         * @throws MatrixIllegalArgumentException if {@code rows < 2 || cols < 2}
         */
        @Test
        void testCreateZeroMatrix() {
            new Matrix<Integer>(2,2);
        }

        /**
         * Create matrix with wrong cols argument
         * 1. Create matrix with {@code cols < 2}
         *  a. check that exception with correct error message was thrown
         * @throws MatrixIllegalArgumentException if {@code cols < 2 || rows < 2}
         */
        @Test
        void testCreateZeroMatrixWrongColumns() {
            Exception exception = assertThrows(MatrixIllegalArgumentException.class, () -> new Matrix<Integer>(2, 1));
            assertEquals(exception.getMessage(), MatrixIllegalArgumentException.WRONG_COLUMNS_NUMBER_MESSAGE);
        }

        /**
         * Create matrix with wrong rows argument
         * 1. Create matrix with {@code rows < 2}
         *  a. check that exception with correct error message was thrown
         * @throws MatrixIllegalArgumentException if {@code cols < 2 || rows < 2}
         */
        @Test
        void testCreateZeroMatrixWrongRows() {
            Exception exception = assertThrows(MatrixIllegalArgumentException.class, () -> new Matrix<Integer>(1,2));
            assertEquals(exception.getMessage(), MatrixIllegalArgumentException.WRONG_ROWS_NUMBER_MESSAGE);
        }
    }

    /**
     * Feature: testing mutator methods from Matrix class
     * @author Alexander Fal (falalexandr007@gmail.com)
     */
    @Nested
    @DisplayName("Mutators")
    class MutatorsTests {
        /**
         * Valid arguments
         * 1. Use {@link Matrix#set(int, int, Number)} method with valid arguments
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testSetValidIndex() {
            matrix.set(0, 0, 21);
        }

        /**
         * Row index is negative
         * 1. Use {@link Matrix#set(int, int, Number)} method with negative row index
         *  a. Check if exception with correct message was thrown
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testSetNegativeRowIndex() {
            BadIndexException exception = assertThrows(BadIndexException.class, () -> matrix.set(-1, 0, 21));
            assertEquals(exception.getMessage(), BadIndexException.NEGATIVE_INDEX_MESSAGE);
        }

        /**
         * Column index is negative
         * 1. Use {@link Matrix#set(int, int, Number)} method with negative column index
         *  a. Check if exception with correct message was thrown
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testSetNegativeColumnIndex() {
            BadIndexException exception = assertThrows(BadIndexException.class, () -> matrix.set(0, -1, 21));
            assertEquals(exception.getMessage(), BadIndexException.NEGATIVE_INDEX_MESSAGE);
        }

        /**
         * Row index is >= {@link Matrix#getRows()}
         * 1. Use {@link Matrix#set(int, int, Number)} method with row >= {@link Matrix#getRows()}
         *  a. Check if exception with correct message was thrown
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testSetOutOfBoundsRowIndex() {
            BadIndexException exception = assertThrows(BadIndexException.class, () -> matrix.set(21, 0, 21));
            assertEquals(exception.getMessage(), BadIndexException.INDEX_OUT_OF_BOUNDS_MESSAGE);
        }

        /**
         * Column index is >= {@link Matrix#getCols()}
         * 1. Use {@link Matrix#set(int, int, Number)} method with col >= {@link Matrix#getCols()}
         *  a. Check if exception with correct message was thrown
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testSetOutOfBoundsColumnIndex() {
            BadIndexException exception = assertThrows(BadIndexException.class, () -> matrix.set(0, 21, 21));
            assertEquals(exception.getMessage(), BadIndexException.INDEX_OUT_OF_BOUNDS_MESSAGE);
        }

        /**
         * Add {@code rows * columns} values
         * 1. Use {@link Matrix#addAll(Number[])} with {@code rows * columns} values
         */
        @Test
        void testAddAll() {
            Matrix tmp = matrix.addAll(1, 2, 3, 4);
            assertEquals(tmp, matrix);

            for(int i = 0; i < dimensions; i++) {
                for(int j = 0; j < dimensions; j++)
                    assertEquals((int) matrix.get(i,j), i * dimensions + j + 1);
            }
        }

        /**
         * Add values, for which {@code rows * columns > values.length}
         * 1. Use {@link Matrix#addAll(Number[])} with {@code rows * columns - 1} values
         */
        @Test
        void testAddAllLessThenDimensions() {
            Matrix tmp = matrix.addAll(1, 2, 3);
            assertEquals(tmp, matrix);

            for(int i = 0; i < 1; i++) {
                for(int j = 0; j < dimensions; j++)
                    assertEquals((int) matrix.get(i,j), i * dimensions + j + 1);
            }
        }

        /**
         * Add values, for which {@code rows * columns < values.length}
         * 1. Use {@link Matrix#addAll(Number[])} with {@code rows * columns +1} values
         */
        @Test
        void testAddAllMoreThenDimensions() {
            Matrix tmp = matrix.addAll(1, 2, 3, 4, 5);
            assertEquals(tmp, matrix);

            for(int i = 0; i < dimensions; i++) {
                for(int j = 0; j < dimensions; j++)
                    assertEquals((int) matrix.get(i,j), i * dimensions + j + 1);
            }
        }
    }

    /**
     * Feature: testing accessor methods from Matrix class
     * @author Alexander Fal (falalexandr007@gmail.com)
     */
    @Nested
    @DisplayName("Accessors")
    class AccessorsTests {
        /**
         * Get element with valid index
         * 1. Use {@link Matrix#get(int, int)} with valid arguments
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testGetValidIndex() {
            matrix.get(0,0);
        }

        /**
         * Get element with negative index
         * 1. Use {@link Matrix#get(int, int)} with negative index
         *  a. check if exception with correct message was thrown
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testGetNegativeIndex() {
            BadIndexException exception = assertThrows(BadIndexException.class, () -> matrix.get(-1, 0));
            assertEquals(exception.getMessage(), BadIndexException.NEGATIVE_INDEX_MESSAGE);
        }

        /**
         * Get element with index >= {@link Matrix#getRows()}
         * 1. Use {@link Matrix#get(int, int)} with index >= {@link Matrix#getRows()}
         *  a. check if exception with correct message was thrown
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testGetOutOfBoundsIndex() {
            BadIndexException exception = assertThrows(BadIndexException.class, () -> matrix.get(21, 0));
            assertEquals(exception.getMessage(), BadIndexException.INDEX_OUT_OF_BOUNDS_MESSAGE);
        }

        /**
         * Get number of rows
         * 1. Use {@link Matrix#getRows()}
         *  a. check if returned value equals to value given to constructor
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testGetRows() {
            assertEquals(matrix.getRows(), dimensions);
        }

        /**
         * Get number of columns
         * 1. Use {@link Matrix#getCols()}
         *  a. check if returned value equals to value given to constructor
         * @throws BadIndexException if row or column index is negative
         *                           or row >= {@link Matrix#getRows()} or column >= {@link Matrix#getCols()}
         */
        @Test
        void testGetCols() {
            assertEquals(matrix.getCols(), dimensions);
        }
    }
}