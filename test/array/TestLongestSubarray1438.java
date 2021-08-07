package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/23
 */
public class TestLongestSubarray1438 extends TestCase {

    private LongestSubarray1438 longestSubarray = new LongestSubarray1438();

    public void test1() {
        int longest = longestSubarray.longestSubarray(new int[]{8, 2, 4, 7}, 4);
        Assert.assertEquals(longest, 2);
    }

    public void test2() {
        int longest = longestSubarray.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0);
        Assert.assertEquals(longest, 8);
    }

    public void test3() {
        int longest = longestSubarray.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 2);
        Assert.assertEquals(longest, 3);
    }
}
