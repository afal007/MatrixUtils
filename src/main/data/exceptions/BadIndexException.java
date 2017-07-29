package main.data.exceptions;

public class BadIndexException extends IndexOutOfBoundsException {
    public static final String NEGATIVE_INDEX_MESSAGE       = "Index can't be negative";
    public static final String INDEX_OUT_OF_BOUNDS_MESSAGE  = "Index out of bounds";

    public BadIndexException() {
        super();
    }

    public BadIndexException(String s) {
        super(s);
    }
}
