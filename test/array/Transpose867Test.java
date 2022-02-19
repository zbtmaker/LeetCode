package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class Transpose867Test extends TestCase {

    private final Transpose867 transpose = new Transpose867();

    public void test1() {
        int[][] result = transpose.transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Assert.assertArrayEquals(result[0], new int[]{1, 4, 7});
        Assert.assertArrayEquals(result[1], new int[]{2, 5, 8});
        Assert.assertArrayEquals(result[2], new int[]{3, 6, 9});
    }

    public void test2() {
        int[][] result = transpose.transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        Assert.assertArrayEquals(result[0], new int[]{1, 4});
        Assert.assertArrayEquals(result[1], new int[]{2, 5});
        Assert.assertArrayEquals(result[2], new int[]{3, 6});
    }
}
