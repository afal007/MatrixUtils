package test.main.utils;

import main.data.Matrix;
import main.utils.MatrixUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Feature: testing operations from MatrixUtils class
 * @author Alexander Fal (falalexandr007@gmail.com)
 */
class MatrixUtilsTest {
    private static final Double[][] dLeftSquareArr =    new Double[][] {{1.1, 1.}, {1., 1.}};
    private static final Double[][] dRightSquareArr =   new Double[][] {{2., 2.}, {2., 2.}};
    private static final Double[][] dSquareArr =        new Double[][] {{1., 2.}, {3., 4.}};

    private static final Integer[][] iLeftSquareArr =   new Integer[][] {{1, 1}, {1, 1}};
    private static final Integer[][] iRightSquareArr =  new Integer[][] {{2, 2}, {2, 2}};
    private static final Integer[][] iSquareArr =       new Integer[][] {{1, 2}, {3, 4}};

    private static final Double[][] dLeftRectArr =      new Double[][] {{1.1, 1., 1.}, {1., 1., 1.}};
    private static final Double[][] dRightRectArr =     new Double[][] {{2., 2.}, {2., 2.}, {2., 2.}};
    private static final Double[][] dRectArr =          new Double[][] {{1., 2., 3.}, {4., 5., 6.}};

    private static final Integer[][] iLeftRectArr =     new Integer[][] {{1, 1, 1}, {1, 1, 1}};
    private static final Integer[][] iRightRectArr =    new Integer[][] {{2, 2}, {2, 2}, {2, 2}};
    private static final Integer[][] iRectArr =         new Integer[][] {{1, 2, 3}, {4, 5, 6}};

    private static final Matrix<Double> dLeftSquare =   Matrix.of(Double.class).initFrom(dLeftSquareArr);
    private static final Matrix<Double> dRightSquare =  Matrix.of(Double.class).initFrom(dRightSquareArr);
    private static final Matrix<Double> dSquare =       Matrix.of(Double.class).initFrom(dSquareArr);

    private static final Matrix<Integer> iLeftSquare =  Matrix.of(Integer.class).initFrom(iLeftSquareArr);
    private static final Matrix<Integer> iRightSquare = Matrix.of(Integer.class).initFrom(iRightSquareArr);
    private static final Matrix<Integer> iSquare =      Matrix.of(Integer.class).initFrom(iSquareArr);

    private static final Matrix<Double> dLeftRect =     Matrix.of(Double.class).initFrom(dLeftRectArr);
    private static final Matrix<Double> dRightRect =    Matrix.of(Double.class).initFrom(dRightRectArr);
    private static final Matrix<Double> dRect =         Matrix.of(Double.class).initFrom(dRectArr);

    private static final Matrix<Integer> iLeftRect =    Matrix.of(Integer.class).initFrom(iLeftRectArr);
    private static final Matrix<Integer> iRightRect =   Matrix.of(Integer.class).initFrom(iRightRectArr);
    private static final Matrix<Integer> iRect =        Matrix.of(Integer.class).initFrom(iRectArr);

    @Nested
    @DisplayName("Double tests")
    class doubleTests {
        @Test
        void testMultSquareDouble() {
            Matrix res = MatrixUtils.mult(dLeftSquare, dRightSquare);

            for(int i = 0; i < res.getRows(); i++)
                for(int j = 0; j < res.getCols(); j++)
                    assertEquals(calcExpected(dLeftSquareArr, dRightSquareArr, i, j) , res.get(i, j));
        }

        @Test
        void testMultRectDouble() {
            Matrix res = MatrixUtils.mult(dLeftRect, dRightRect);

            for(int i = 0; i < res.getRows(); i++)
                for(int j = 0; j < res.getCols(); j++)
                    assertEquals(calcExpected(dLeftRectArr, dRightRectArr, i, j) , res.get(i, j));
        }

        private double calcExpected(Double[][] dLeftSquareArr, Double[][] dRightSquareArr, int i, int j) {
            double res = 0;
            for(int k = 0; k < dLeftSquareArr[0].length; k++)
                res += dLeftSquareArr[i][k] * dRightSquareArr[k][j];
            return res;
        }

        @Test
        void testAddDouble() {
            Matrix res = MatrixUtils.add(dLeftSquare, dRightSquare);

            for(int i = 0; i < res.getRows(); i++)
                for(int j = 0; j < res.getCols(); j++)
                    assertEquals(dLeftSquareArr[i][j] +  dRightSquareArr[i][j] , res.get(i, j));
        }

        @Test
        void testSubDouble() {
            Matrix res = MatrixUtils.sub(dLeftSquare, dRightSquare);

            for(int i = 0; i < res.getRows(); i++)
                for(int j = 0; j < res.getCols(); j++)
                    assertEquals(dLeftSquareArr[i][j] - dRightSquareArr[i][j] , res.get(i, j));
        }

        @Test
        void testTransposeSquareDouble() {
            Matrix res = MatrixUtils.transpose(dSquare);

            for(int i = 0; i < res.getRows(); i++)
                for(int j = 0; j < res.getCols(); j++)
                    assertEquals(dSquareArr[i][j], res.get(j, i));
        }

        @Test
        void testTransposeRectDouble() {
            Matrix res = MatrixUtils.transpose(dRect);

            for(int i = 0; i < dRectArr.length; i++)
                for(int j = 0; j < dRectArr[0].length; j++)
                    assertEquals(dRectArr[i][j], res.get(j, i));
        }

        @Test
        void testMultScalarDouble() {
            double scalar = 2.;
            Matrix res = MatrixUtils.mult(dSquare, scalar);

            for(int i = 0; i < res.getRows(); i++)
                for(int j = 0; j < res.getCols(); j++)
                    assertEquals(dSquareArr[i][j] * scalar , res.get(i, j));
        }

    }


    @Nested
    @DisplayName("Integer tests")
    class intTests {
        @Test
        void testMultSquareInteger() {
            Matrix res = MatrixUtils.mult(iLeftSquare, iRightSquare);

            for (int i = 0; i < res.getRows(); i++)
                for (int j = 0; j < res.getCols(); j++)
                    assertEquals(calcExpected(iLeftSquareArr, iRightSquareArr, i, j), res.get(i, j));
        }

        @Test
        void testMultRectInteger() {
            Matrix res = MatrixUtils.mult(iLeftRect, iRightRect);

            for (int i = 0; i < res.getRows(); i++)
                for (int j = 0; j < res.getCols(); j++)
                    assertEquals(calcExpected(iLeftRectArr, iRightRectArr, i, j), res.get(i, j));
        }

        private int calcExpected(Integer[][] iLeftSquareArr, Integer[][] iRightSquareArr, int i, int j) {
            int res = 0;
            for (int k = 0; k < iLeftSquareArr[0].length; k++)
                res += iLeftSquareArr[i][k] * iRightSquareArr[k][j];
            return res;
        }

        @Test
        void testAddInteger() {
            Matrix res = MatrixUtils.add(iLeftSquare, iRightSquare);

            for (int i = 0; i < res.getRows(); i++)
                for (int j = 0; j < res.getCols(); j++)
                    assertEquals(iLeftSquareArr[i][j] + iRightSquareArr[i][j], res.get(i, j));
        }

        @Test
        void testSubInteger() {
            Matrix res = MatrixUtils.sub(iLeftSquare, iRightSquare);

            for (int i = 0; i < res.getRows(); i++)
                for (int j = 0; j < res.getCols(); j++)
                    assertEquals(iLeftSquareArr[i][j] - iRightSquareArr[i][j], res.get(i, j));
        }

        @Test
        void testTransposeSquareInteger() {
            Matrix res = MatrixUtils.transpose(iSquare);

            for (int i = 0; i < res.getRows(); i++)
                for (int j = 0; j < res.getCols(); j++)
                    assertEquals(iSquareArr[i][j], res.get(j, i));
        }

        @Test
        void testTransposeRectInteger() {
            Matrix res = MatrixUtils.transpose(iRect);

            for (int i = 0; i < iRectArr.length; i++)
                for (int j = 0; j < iRectArr[0].length; j++)
                    assertEquals(iRectArr[i][j], res.get(j, i));
        }

        @Test
        void testMultScalarInteger() {
            int scalar = 2;
            Matrix res = MatrixUtils.mult(iSquare, scalar);

            for (int i = 0; i < res.getRows(); i++)
                for (int j = 0; j < res.getCols(); j++)
                    assertEquals(iSquareArr[i][j] * scalar, res.get(i, j));
        }
    }

}