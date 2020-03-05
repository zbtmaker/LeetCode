package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/22
 */
public class CheckSubarraySum523Test {
    private CheckSubarraySum523 sum = new CheckSubarraySum523();

    @Test
    public void test1() {
        boolean flag = sum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        boolean flag = sum.checkSubarraySum(new int[]{23}, 6);
        Assert.assertFalse(flag);
    }

    @Test
    public void test3() {
        boolean flag = sum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 0);
        Assert.assertFalse(flag);
    }

    @Test
    public void test4() {
        boolean flag = sum.checkSubarraySum(new int[]{0, 0, 0, 0, 0}, 0);
        Assert.assertTrue(flag);
    }

    @Test
    public void test5() {
        boolean flag = sum.checkSubarraySum(new int[]{0, 0, 0, 0, 0}, 0);
        Assert.assertTrue(flag);
    }
}
