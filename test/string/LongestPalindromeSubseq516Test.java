package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/14
 */
public class LongestPalindromeSubseq516Test {

    private LongestPalindromeSubseq516 longest = new LongestPalindromeSubseq516();

    @Test
    public void test1() {
        int max = longest.longestPalindromeSubseq("bbbab");
        Assert.assertEquals(max, 4);
    }

    @Test
    public void test2() {
        int max = longest.longestPalindromeSubseq("cbbd");
        Assert.assertEquals(max, 2);
    }

    @Test
    public void test3() {
        int max = longest.longestPalindromeSubseq("cbbdbdc");
        Assert.assertEquals(max, 5);
    }

    @Test
    public void test4() {
        int max = longest.longestPalindromeSubseq("cc");
        Assert.assertEquals(max, 2);
    }

    @Test
    public void test5() {
        int max = longest.longestPalindromeSubseq("c");
        Assert.assertEquals(max, 1);
    }
}
