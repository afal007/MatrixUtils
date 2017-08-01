package main.data.exceptions;

/**
 * author: Alexander Fal (falalexandr007@gmail.com)
 */
public class MatrixNotInitializedException extends RuntimeException {
    public static final String MATRIX_IS_NOT_INITIALIZED_MESSAGE = "Matrix was not initialized";

    public MatrixNotInitializedException() {
        super();
    }

    public MatrixNotInitializedException(String message) {
        super(message);
    }
}
