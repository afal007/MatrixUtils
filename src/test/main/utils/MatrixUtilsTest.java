package test.main.utils;

import main.data.Matrix;
import main.utils.MatrixUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {
    private static final Matrix<Integer> left = new Matrix<>(new Integer[][] {{1,1},{1,1}});
    private static final Matrix<Integer> right = new Matrix<>(new Integer[][] {{2,2},{2,2}});

    @Test
    void testMult() {
        Matrix res = MatrixUtils.mult(left, right);

        assertEquals(4, res.get(0,0));
        assertEquals(4 ,res.get(0,1));
        assertEquals(4, res.get(1,0));
        assertEquals(4 ,res.get(1,1));
    }

}