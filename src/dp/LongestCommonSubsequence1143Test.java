package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/16
 */
public class LongestCommonSubsequence1143Test {

    private LongestCommonSubsequence1143 longest = new LongestCommonSubsequence1143();

    @Test
    public void test1() {
        int len = longest.longestCommonSubsequence("abcde", "ace");
        Assert.assertEquals(len,3);
    }

    @Test
    public void test2() {
        int len = longest.longestCommonSubsequence("abc", "abc");
        Assert.assertEquals(len,3);
    }

    @Test
    public void test3() {
        int len = longest.longestCommonSubsequence("abc", "def");
        Assert.assertEquals(len,0);
    }
    @Test
    public void test4() {
        int len = longest.longestCommonSubsequence("a", "bca");
        Assert.assertEquals(len,1);
    }
}
