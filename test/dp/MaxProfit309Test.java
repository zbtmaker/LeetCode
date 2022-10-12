package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/12
 */
public class MaxProfit309Test extends TestCase {

    private final MaxProfit309 maxProfit = new MaxProfit309();

    public void test1() {
        int ans = maxProfit.maxProfit(new int[]{1, 2, 3, 0, 2});
        Assert.assertEquals(ans, 3);
    }

    public void test2() {
        int ans = maxProfit.maxProfit(new int[]{1});
        Assert.assertEquals(ans, 0);
    }
}
