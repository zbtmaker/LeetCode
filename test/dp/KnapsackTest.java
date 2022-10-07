package dp;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/23
 */
public class KnapsackTest extends TestCase {
    private final Knapsack knapsack = new Knapsack();

    public void test1() {
        int maxValue = knapsack.knapsack(10, new int[]{5, 4, 6, 3}, new int[]{10, 40, 30, 50});
        Assert.assertEquals(maxValue, 90);
    }
}
