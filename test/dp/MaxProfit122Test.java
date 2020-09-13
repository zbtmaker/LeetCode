package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class MaxProfit122Test extends TestCase {

    private MaxProfit122 maxProfit = new MaxProfit122();


    public void test1() {
        int max = maxProfit.maxProfit(new int[]{});
        Assert.assertEquals(max, 0);
    }

    public void test2() {
        int max = maxProfit.maxProfit(new int[]{1});
        Assert.assertEquals(max, 0);
    }


    public void test3() {
        int max = maxProfit.maxProfit(new int[]{1, 1});
        Assert.assertEquals(max, 0);
    }

    public void test4() {
        int max = maxProfit.maxProfit(new int[]{2, 1});
        Assert.assertEquals(max, 0);
    }

    public void test5() {
        int max = maxProfit.maxProfit(new int[]{2, 1, 6, 5, 8});
        Assert.assertEquals(max, 8);
    }

    public void test6() {
        int max = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(max, 7);
    }

    public void test7() {
        int max = maxProfit.maxProfit(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals(max, 4);
    }

    public void test8() {
        int max = maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1});
        Assert.assertEquals(max, 0);
    }
}
