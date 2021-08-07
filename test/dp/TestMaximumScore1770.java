package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/23
 */
public class TestMaximumScore1770 extends TestCase {
    private MaximumScore1770 maximumScore = new MaximumScore1770();

    public void test1() {
        int max = maximumScore.maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        Assert.assertEquals(max, 14);
    }

    public void test2() {
        int max = maximumScore.maximumScore(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6});
        Assert.assertEquals(max, 102);
    }
}
