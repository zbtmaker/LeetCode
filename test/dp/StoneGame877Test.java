package dp;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/13
 */
public class StoneGame877Test extends TestCase {

    private StoneGame877 game = new StoneGame877();

    public void test1() {
        boolean result = game.stoneGame(new int[]{5, 4, 3, 5});
        Assert.assertTrue(result);
    }

    public void test2() {
        boolean result = game.stoneGame(new int[]{1, 3, 1});
        Assert.assertFalse(result);
    }

    public void test3() {
        boolean result = game.stoneGame(new int[]{1, 3});
        Assert.assertTrue(result);
    }

    public void test4() {
        boolean result = game.stoneGame(new int[]{3, 1});
        Assert.assertTrue(result);
    }

    public void test5() {
        boolean result = game.stoneGame(new int[]{3});
        Assert.assertTrue(result);
    }

}
