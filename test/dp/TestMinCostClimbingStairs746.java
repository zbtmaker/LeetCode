package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/22
 */
public class TestMinCostClimbingStairs746 {

    private MinCostClimbingStairs746 minCost = new MinCostClimbingStairs746();

    @Test
    public void test1() {
        int min = minCost.minCostClimbingStairs(new int[]{10, 15, 20});
        Assert.assertEquals(min, 15);
    }

    @Test
    public void test2() {
        int min = minCost.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        Assert.assertEquals(min, 6);
    }
}
