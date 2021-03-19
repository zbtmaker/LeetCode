package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/19
 */
public class TestMinOperations1769 extends TestCase {
    private MinOperations1769 min = new MinOperations1769();

    public void test1() {
        int[] result = min.minOperations("110");
        Assert.assertArrayEquals(result, new int[]{1, 1, 3});
    }

    public void test2() {
        int[] result = min.minOperations("001011");
        Assert.assertArrayEquals(result, new int[]{11, 8, 5, 4, 3, 4});
    }
}
