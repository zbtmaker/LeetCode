package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/09
 */
public class TestMaxProfit123 extends TestCase {

    private MaxProfit123 maxProfit = new MaxProfit123();

    public void test1() {
        int max = maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1});
        Assert.assertEquals(max, 0);
    }

    public void test2() {
        int max = maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1});
        Assert.assertEquals(max, 0);
    }

    public void test3() {
        int max = maxProfit.maxProfit(new int[]{6,1,3,2,4,7});
        Assert.assertEquals(max, 7);
    }

}
