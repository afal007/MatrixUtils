package main.data.arithmetic;

/**
 * short wraper with basic arithmetic operations
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
public class RichShort implements Numeric<Short> {
    private short val;

    public RichShort(short val){
        this.val = val;
    }

    public static RichShort of(short val) {
        return new RichShort(val);
    }

    @Override
    public Numeric<Short> add(Short right) {
        return RichShort.of((short) (val + right));
    }

    @Override
    public Numeric<Short> sub(Short right) { return RichShort.of((short) (val + right));
    }

    @Override
    public Numeric<Short> mult(Short right) {
        return RichShort.of((short) (val * right));
    }

    @Override
    public Numeric<Short> div(Short right) {
        return RichShort.of((short) (val / right));
    }

    @Override
    public Short getVal() {
        return val;
    }
}