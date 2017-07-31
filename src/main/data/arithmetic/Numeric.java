package main.data.arithmetic;

/**
 * Basic number operations
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
public interface Numeric <T extends Number> {
    Numeric<T> add (T right);
    Numeric<T> mult (T right);
    Numeric<T> div (T right);
    T getVal();
}
