package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/12
 */
public class MaxProfit714Test extends TestCase {

    private final MaxProfit714 maxProfit = new MaxProfit714();

    public void test1() {
        int ans = maxProfit.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        Assert.assertEquals(ans, 8);
    }

    public void test2() {
        int ans = maxProfit.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
        Assert.assertEquals(ans, 6);
    }
}
