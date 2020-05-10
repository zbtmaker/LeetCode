package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/10
 */
public class SetZeroes73Test {
    private SetZeroes73 zeroes = new SetZeroes73();

    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1, 1, 1},
                {0, 1, 2}};
        zeroes.setZeroes(matrix);
        Assert.assertArrayEquals(matrix, new int[][]{{0, 1, 1}, {0, 0, 0}});
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        zeroes.setZeroes(matrix);
        Assert.assertArrayEquals(matrix, new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        });
    }
}
