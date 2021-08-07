package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2020/12/27
 */
public class StoneGameII1140Test extends TestCase {

    private StoneGameII1140 game = new StoneGameII1140();

    public void test1() {
        int result = game.stoneGameII(new int[]{2, 7, 9, 4, 4});
        Assert.assertEquals(result, 10);
    }
}
