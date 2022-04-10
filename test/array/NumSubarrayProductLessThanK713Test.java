package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/10
 */
public class NumSubarrayProductLessThanK713Test extends TestCase {
    private NumSubarrayProductLessThanK713 num = new NumSubarrayProductLessThanK713();

    public void test1() {
        int res = num.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        Assert.assertEquals(res, 8);
    }

    public void test2() {
        int res = num.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 10);
        Assert.assertEquals(res, 3);
    }

    public void test3() {
        int res = num.numSubarrayProductLessThanK(new int[]{10, 5, 2, 3}, 10);
        Assert.assertEquals(res, 4);
    }

    public void test4() {
        int res = num.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0);
        Assert.assertEquals(res, 0);
    }
}
