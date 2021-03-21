package hash;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Baitao Zou
 * date 2021/03/20
 */
public class TestDailyTemperatures739 extends TestCase {

    private DailyTemperatures739 daily = new DailyTemperatures739();

    @Test
    public void test1() {
        int[] raise = daily.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        Assert.assertArrayEquals(raise, new int[]{1, 1, 4, 2, 1, 1, 0, 0});
    }
}
