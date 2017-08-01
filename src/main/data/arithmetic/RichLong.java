package main.data.arithmetic;

/**
 * long wraper with basic arithmetic operations
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
public class RichLong implements Numeric<Long>{
    private long val;

    public RichLong(long val) {
        this.val = val;
    }

    public static RichLong of(long val) {
        return new RichLong(val);
    }

    @Override
    public Numeric<Long> add(Long right) {
        return RichLong.of(val + right);
    }

    @Override
    public Numeric<Long> sub(Long right) {
        return RichLong.of(val + right);
    }

    @Override
    public Numeric<Long> mult(Long right) {
        return RichLong.of(val * right);
    }

    @Override
    public Numeric<Long> div(Long right) {
        return RichLong.of(val / right);
    }

    @Override
    public Long getVal() {
        return val;
    }
}
