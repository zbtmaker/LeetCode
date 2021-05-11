package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/05/11
 */
public class MaxSumMinProduct1856Test extends TestCase {
    private MaxSumMinProduct1856 maxSum = new MaxSumMinProduct1856();

    public void test1() {
        int max = maxSum.maxSumMinProduct(new int[]{1, 2, 3, 2});
        Assert.assertEquals(max, 14);
    }

    public void test2() {
        int max = maxSum.maxSumMinProduct(new int[]{2, 3, 3, 1, 2});
        Assert.assertEquals(max, 18);
    }

    public void test3() {
        int max = maxSum.maxSumMinProduct(new int[]{3, 1, 5, 6, 4, 2});
        Assert.assertEquals(max, 60);
    }

    public void test4() {
        int max = maxSum.maxSumMinProduct(new int[]{5, 10, 6, 10, 4, 2, 1, 4, 5, 2, 4, 2, 7, 5, 8, 6, 3, 6, 6, 4});
        Assert.assertEquals(max, 156);
    }
}
