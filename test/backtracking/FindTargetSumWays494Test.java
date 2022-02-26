package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/01
 */
public class FindTargetSumWays494Test extends TestCase {

    private final FindTargetSumWays494 find = new FindTargetSumWays494();

    public void test1() {
        int result = find.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        Assert.assertEquals(result, 5);
    }

    public void test2() {
        int result = find.findTargetSumWays(new int[]{1, 1}, 0);
        Assert.assertEquals(result, 2);
    }

    public void test3() {
        int result = find.findTargetSumWays(new int[]{1}, 0);
        Assert.assertEquals(result, 0);
    }
}
