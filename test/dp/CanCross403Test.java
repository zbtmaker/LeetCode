package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class CanCross403Test {

    private CanCross403 can = new CanCross403();

    @Test
    public void test1() {
        boolean result = can.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        Assert.assertTrue(result);
    }

    @Test
    public void test2() {
        boolean result = can.canCross(new int[]{0,1,2,3,4,8,9,11});
        Assert.assertFalse(result);
    }
}
