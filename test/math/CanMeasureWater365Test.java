package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/21
 */
public class CanMeasureWater365Test {
    public CanMeasureWater365 can = new CanMeasureWater365();

    @Test
    public void test1() {
        boolean result = can.canMeasureWater(2, 6, 5);
        Assert.assertFalse(result);
    }

    @Test
    public void test2() {
        boolean result = can.canMeasureWater(2, 6, 4);
        Assert.assertTrue(result);
    }

    @Test
    public void test3() {
        boolean result = can.canMeasureWater(3, 5, 4);
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        boolean result = can.canMeasureWater(0, 2, 1);
        Assert.assertFalse(result);
    }

    @Test
    public void test5() {
        boolean result = can.canMeasureWater(1, 2, 3);
        Assert.assertTrue(result);
    }

    @Test
    public void test6() {
        boolean result = can.canMeasureWater(4, 6, 8);
        Assert.assertTrue(result);
    }

    @Test
    public void test7() {
        boolean result = can.canMeasureWater(1, 1, 0);
        Assert.assertTrue(result);
    }

    @Test
    public void test8() {
        boolean result = can.canMeasureWater(13, 11, 1);
        Assert.assertTrue(result);
    }
}
