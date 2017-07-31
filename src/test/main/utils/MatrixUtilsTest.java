package test.main.utils;

import main.data.Matrix;
import main.utils.MatrixUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {
    private static final Matrix<Double> left = new Matrix<>(new Double[][] {{1., 1.},{1., 1.}});
    private static final Matrix<Double> right = new Matrix<>(new Double[][] {{2., 2.},{2., 2.}});

    @Test
    void testMult() {
        Matrix res = MatrixUtils.mult(left, right);

        assertEquals(1. * 2. + 1. * 2. , res.get(0,0));
        assertEquals(1. * 2. + 1. * 2. , res.get(0,1));
        assertEquals(1. * 2. + 1. * 2. , res.get(1,0));
        assertEquals(1. * 2. + 1. * 2. , res.get(1,1));
    }

}