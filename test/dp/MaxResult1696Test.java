package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/09
 */
public class MaxResult1696Test extends TestCase {

    private final MaxResult1696 max = new MaxResult1696();

    public void test1() {
        int ans = max.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2);
        Assert.assertEquals(ans, 7);
    }

    public void test2() {
        int ans = max.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3);
        Assert.assertEquals(ans, 17);
    }

    public void test3() {
        int ans = max.maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2);
        Assert.assertEquals(ans, 0);
    }
}
