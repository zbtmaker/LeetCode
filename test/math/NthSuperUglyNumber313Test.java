package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class NthSuperUglyNumber313Test {
    private NthSuperUglyNumber313 ugly = new NthSuperUglyNumber313();

    @Test
    public void test1() {
        int result = ugly.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        Assert.assertEquals(result, 32);
    }

    @Test
    public void test2() {
        int result = ugly.nthSuperUglyNumber(7, new int[]{2, 3, 5});
        Assert.assertEquals(result, 8);
    }
}
