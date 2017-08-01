package main.data.arithmetic;

/**
 * float wraper with basic arithmetic operations
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
public class RichFloat implements Numeric<Float> {
    private float val;

    public RichFloat(float val) {
        this.val = val;
    }

    public static RichFloat of(float val) {
        return new RichFloat(val);
    }

    @Override
    public Numeric<Float> add(Float right) {
        return RichFloat.of(val + right);
    }

    @Override
    public Numeric<Float> sub(Float right) {
        return RichFloat.of(val - right);
    }

    @Override
    public Numeric<Float> mult(Float right) {
        return RichFloat.of(val * right);
    }

    @Override
    public Numeric<Float> div(Float right) {
        return RichFloat.of(val / right);
    }

    @Override
    public Float getVal() {
        return val;
    }
}
