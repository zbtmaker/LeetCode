package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2020/12/25
 */
public class StoneGameVII1690Test extends TestCase {

    private StoneGameVII1690 game = new StoneGameVII1690();

    public void test1() {
        int result = game.stoneGameVII(new int[]{5, 3, 1, 4, 2});
        Assert.assertEquals(result, 6);
    }
}
