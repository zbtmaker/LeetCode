package dp;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class MaxProfit121Test extends TestCase {

    private MaxProfit121 maxProfit = new MaxProfit121();

    public void test1() {
        int max = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(max, 5);
    }

    public void test2() {
        int max = maxProfit.maxProfit(new int[]{1, 2});
        Assert.assertEquals(max, 1);
    }
}
