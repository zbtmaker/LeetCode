package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/21
 */
public class MinFallingPathSum931Test extends TestCase {
    private final MinFallingPathSum931 min = new MinFallingPathSum931();

    public void test1() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int res = min.minFallingPathSum(matrix);
        Assert.assertEquals(res, 12);
    }

    public void test2() {
        int[][] matrix = new int[][]{
                {2, 1, 3}, {6, 5, 4}, {7, 8, 9}
        };
        int res = min.minFallingPathSum(matrix);
        Assert.assertEquals(res, 13);
    }

    public void test3() {
        int[][] matrix = new int[][]{
                {2}
        };
        int res = min.minFallingPathSum(matrix);
        Assert.assertEquals(res, 2);
    }

    public void test4() {
        int[][] matrix = new int[][]{
                {-19, 57}, {-40, -5}
        };
        int res = min.minFallingPathSum(matrix);
        Assert.assertEquals(res, -59);
    }
}
