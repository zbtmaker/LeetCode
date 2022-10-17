package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/15
 */
public class StoneGameVIII1872Test extends TestCase {

    private final StoneGameVIII1872 stoneGameVIII1872 = new StoneGameVIII1872();

    public void test1() {
        int ans = stoneGameVIII1872.stoneGameVIII(new int[]{-1, 2, -3, 4, -5});
        Assert.assertEquals(ans, 5);
    }
}
