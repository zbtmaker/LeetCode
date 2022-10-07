package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/04
 */
public class MultiKnapsackTest extends TestCase {

    private final MultiKnapsack knapsack = new MultiKnapsack();

    public void test1() {
        int W = 20;
        int[] v = new int[]{3, 5, 9, 8};
        int[] w = new int[]{9, 9, 4, 1};
        int[] nums = new int[]{3, 1, 2, 3};
        int res = knapsack.multiKnapsack(W, w, v, nums);
        Assert.assertEquals(res, 47);
    }

}
