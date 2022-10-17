package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/15
 */
public class StoneGameV1563Test extends TestCase {

    private final StoneGameV1563 stoneGame = new StoneGameV1563();

    public void test1() {
        int ans = stoneGame.stoneGameV(new int[]{6, 2, 3, 4, 5, 5});
        Assert.assertEquals(ans, 18);
    }

    public void test2() {
        int ans = stoneGame.stoneGameV(new int[]{2, 3});
        Assert.assertEquals(ans, 2);
    }

    public void test3() {
        int ans = stoneGame.stoneGameV(new int[]{6, 2, 3});
        Assert.assertEquals(ans, 7);
    }

}
