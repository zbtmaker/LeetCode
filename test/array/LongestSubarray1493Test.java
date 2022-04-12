package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/12
 */
public class LongestSubarray1493Test extends TestCase {

    private final LongestSubarray1493 longest = new LongestSubarray1493();

    public void test1() {
        int res = longest.longestSubarray(new int[]{1, 1, 0, 1});
        Assert.assertEquals(res, 3);
    }

    public void test2() {
        int res = longest.longestSubarray(new int[]{1, 1, 1});
        Assert.assertEquals(res, 2);
    }

    public void test3() {
        int res = longest.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
        Assert.assertEquals(res, 5);
    }

    public void test4() {
        int res = longest.longestSubarray(new int[]{0, 0, 1});
        Assert.assertEquals(res, 1);
    }

    public void test5() {
        int res = longest.longestSubarray(new int[]{1});
        Assert.assertEquals(res, 0);
    }

    public void test6() {
        int res = longest.longestSubarray(new int[]{0});
        Assert.assertEquals(res, 0);
    }

    public void test7() {
        int res = longest.longestSubarray(new int[]{1, 1});
        Assert.assertEquals(res, 1, 1);
    }

    public void test8() {
        int res = longest.longestSubarray(new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1});
        Assert.assertEquals(res, 3);
    }

    public void test9() {
        int res = longest.longestSubarray(new int[]{1, 0, 1, 0, 1, 1, 1, 1});
        Assert.assertEquals(res, 5);
    }

    public void test10() {
        int[] nums = new int[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0};
        int res = longest.longestSubarray(nums);
        Assert.assertEquals(res, 14);
    }
}
