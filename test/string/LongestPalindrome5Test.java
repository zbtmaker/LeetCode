package string;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/14
 */
public class LongestPalindrome5Test extends TestCase {
    private final LongestPalindrome5 longest = new LongestPalindrome5();

    public void test1() {
        String palindrome = longest.longestPalindrome("babad");
        Assert.assertEquals(palindrome, "bab");
    }

    public void test2() {
        String palindrome = longest.longestPalindrome("cbba");
        Assert.assertEquals(palindrome, "bb");
    }

    public void test3() {
        String palindrome = longest.longestPalindrome("cbb");
        Assert.assertEquals(palindrome, "bb");
    }

    public void test4() {
        String palindrome = longest.longestPalindrome("bb");
        Assert.assertEquals(palindrome, "bb");
    }

    public void test5() {
        String palindrome = longest.longestPalindrome("b");
        Assert.assertEquals(palindrome, "b");
    }
}
