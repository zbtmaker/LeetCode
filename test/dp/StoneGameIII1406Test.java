package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2020/12/26
 */
public class StoneGameIII1406Test extends TestCase {
    public StoneGameIII1406 game = new StoneGameIII1406();

    public void test1() {
        String result = game.stoneGameIII(new int[]{1, 2, 3, 7});
        Assert.assertEquals(result, "Bob");
    }

    public void test2() {
        String result = game.stoneGameIII(new int[]{1, 2, 3, -9});
        Assert.assertEquals(result, "Alice");
    }

    public void test3() {
        String result = game.stoneGameIII(new int[]{1, 2, 3, 6});
        Assert.assertEquals(result, "Tie");
    }

    public void test4() {
        String result = game.stoneGameIII(new int[]{1, 2, 3, -1, -2, -3, 7});
        Assert.assertEquals(result, "Alice");
    }

    public void test5() {
        String result = game.stoneGameIII(new int[]{-1, -2, -3});
        Assert.assertEquals(result, "Tie");
    }
}
