package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/14
 */
public class LongestPalindrome5Test {
    private LongestPalindrome5 longest = new LongestPalindrome5();

    @Test
    public void test1() {
        String palindrome = longest.longestPalindrome("babad");
        Assert.assertEquals(palindrome, "bab");
    }

    @Test
    public void test2() {
        String palindrome = longest.longestPalindrome("cbba");
        Assert.assertEquals(palindrome, "bb");
    }

    @Test
    public void test3() {
        String palindrome = longest.longestPalindrome("cbb");
        Assert.assertEquals(palindrome, "bb");
    }
    @Test
    public void test4() {
        String palindrome = longest.longestPalindrome("bb");
        Assert.assertEquals(palindrome, "bb");
    }
    @Test
    public void test5() {
        String palindrome = longest.longestPalindrome("b");
        Assert.assertEquals(palindrome, "b");
    }
}
