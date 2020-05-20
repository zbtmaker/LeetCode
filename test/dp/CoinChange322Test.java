package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/05/20
 */
public class CoinChange322Test {

    private CoinChange322 change = new CoinChange322();

    @Test
    public void test1() {
        int count = change.coinChange(new int[]{1, 2, 5}, 11);
        Assert.assertEquals(count, 3);
    }

    @Test
    public void test2() {
        int count = change.coinChange(new int[]{2}, 3);
        Assert.assertEquals(count, -1);
    }

    @Test
    public void test3() {
        int count = change.coinChange(new int[]{474, 83, 404, 3}, 264);
        Assert.assertEquals(count, 8);
    }
}
