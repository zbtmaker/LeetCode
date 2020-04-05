package array;

import dp.LongestIncreasingPath329;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/05
 */
public class LongestIncreasingPath329Test {
    public LongestIncreasingPath329 longest = new LongestIncreasingPath329();

    @Test
    public void test1() {
        int result = longest.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        });
        Assert.assertEquals(result, 4);
    }

    @Test
    public void test2() {
        int result = longest.longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        });
        Assert.assertEquals(result, 4);
    }
}
