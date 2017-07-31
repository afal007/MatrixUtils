package main.data.arithmetic;

/**
 * double wraper with basic arithmetic operations
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
public class RichDouble implements Numeric<Double> {
    private double val;

    public RichDouble(double val) {
        this.val = val;
    }

    public static RichDouble of(double val) {
        return new RichDouble(val);
    }

    @Override
    public Numeric<Double> add(Double right) {
        return RichDouble.of(val + right);
    }

    @Override
    public Numeric<Double> mult(Double right) {
        return RichDouble.of(val * right);
    }

    @Override
    public Numeric<Double> div(Double right) {
        return RichDouble.of(val / right);
    }

    @Override
    public Double getVal() {
        return val;
    }
}
