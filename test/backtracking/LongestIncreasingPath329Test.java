package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/19
 */
public class LongestIncreasingPath329Test extends TestCase {

    private final LongestIncreasingPath329 longest = new LongestIncreasingPath329();

    public void test1() {
        int result = longest.longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}});
        Assert.assertEquals(result, 4);
    }
}
