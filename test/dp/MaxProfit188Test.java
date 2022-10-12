package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/11
 */
public class MaxProfit188Test extends TestCase {

    private final MaxProfit188 maxProfit = new MaxProfit188();

    public void test1() {
        int ans = maxProfit.maxProfit(2, new int[]{2, 4, 1});
        Assert.assertEquals(ans, 2);
    }

    public void test2() {
        int ans = maxProfit.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        Assert.assertEquals(ans, 7);
    }

    public void test3() {
        int ans = maxProfit.maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        Assert.assertEquals(ans, 6);
    }
}
