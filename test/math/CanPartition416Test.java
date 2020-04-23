package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/12
 */
public class CanPartition416Test {
    private CanPartition416 canPartition = new CanPartition416();

    @Test
    public void test1() {
        boolean result = canPartition.canPartition(new int[]{2, 2});
        Assert.assertTrue(result);
    }

    @Test
    public void test2() {
        boolean result = canPartition.canPartition(new int[]{2, 1, 2});
        Assert.assertFalse(result);
    }

    @Test
    public void test3() {
        boolean result = canPartition.canPartition(new int[]{1, 1, 2});
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        boolean result = canPartition.canPartition(new int[]{1, 5, 11, 5});
        Assert.assertTrue(result);
    }

    @Test
    public void test5() {
        boolean result = canPartition.canPartition(new int[]{1, 2, 3, 5});
        Assert.assertFalse(result);
    }
}
