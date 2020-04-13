package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/13
 */
public class StoneGame877Test {

    private StoneGame877 game = new StoneGame877();

    @Test
    public void test1() {
        boolean result = game.stoneGame(new int[]{5, 4, 3, 5});
        Assert.assertTrue(result);
    }

    @Test
    public void test2() {
        boolean result = game.stoneGame(new int[]{1, 3, 1});
        Assert.assertFalse(result);
    }

    @Test
    public void test3() {
        boolean result = game.stoneGame(new int[]{1, 3});
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        boolean result = game.stoneGame(new int[]{3, 1});
        Assert.assertTrue(result);
    }
    @Test
    public void test5() {
        boolean result = game.stoneGame(new int[]{3});
        Assert.assertTrue(result);
    }

}
