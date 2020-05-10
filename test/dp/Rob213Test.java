package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/10
 */
public class Rob213Test {
    private Rob213 rob = new Rob213();

    @Test
    public void test1() {
        int max = rob.rob(new int[]{2, 3, 2});
        Assert.assertEquals(max, 3);
    }

    @Test
    public void test2() {
        int max = rob.rob(new int[]{5, 3});
        Assert.assertEquals(max, 5);
    }

    @Test
    public void test3() {
        int max = rob.rob(new int[]{2});
        Assert.assertEquals(max, 2);
    }
}
