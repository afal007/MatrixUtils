package main.data.exceptions;

public class MatrixIllegalArgumentException extends IllegalArgumentException {
    public static final String WRONG_DIMENSIONS_NUMBER_MESSAGE = "Number of dimensions shouldn't be less then 2";
    public static final String WRONG_ROWS_NUMBER_MESSAGE = "Number of rows shouldn't be less then 2";
    public static final String WRONG_COLUMNS_NUMBER_MESSAGE = "Number of columns shouldn't be less then 2";
    public static final String ARGUMENT_CANT_BE_NULL_MESSAGE = "Argument can't be null";
    public static final String DIFFERENT_ROWS_LENGTH_MESSAGE = "Rows can't have different length";


    public MatrixIllegalArgumentException() {
        super();
    }

    public MatrixIllegalArgumentException(String s) {
        super(s);
    }
}
