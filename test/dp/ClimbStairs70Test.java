package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/08
 */
public class ClimbStairs70Test {

    private ClimbStairs70 climb = new ClimbStairs70();

    @Test
    public void test1() {
        int result = climb.climbStairs(2);
        Assert.assertEquals(result, 2);
    }


    @Test
    public void test2() {
        int result = climb.climbStairs(1);
        Assert.assertEquals(result, 1);
    }


    @Test
    public void test3() {
        int result = climb.climbStairs(3);
        Assert.assertEquals(result, 3);
    }
}
