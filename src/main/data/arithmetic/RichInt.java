package main.data.arithmetic;

/**
 * int wraper with basic arithmetic operations
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
public class RichInt implements Numeric<Integer> {
    private int val;

    public RichInt(int val){
        this.val = val;
    }

    public static RichInt of(int val) {
        return new RichInt(val);
    }

    @Override
    public Numeric<Integer> add(Integer right) {
        return RichInt.of(val + right);
    }

    @Override
    public Numeric<Integer> sub(Integer right) {
        return RichInt.of(val - right);
    }

    @Override
    public Numeric<Integer> mult(Integer right) {
        return RichInt.of(val * right);
    }

    @Override
    public Numeric<Integer> div(Integer right) {
        return RichInt.of(val / right);
    }

    @Override
    public Integer getVal() {
        return val;
    }
}
