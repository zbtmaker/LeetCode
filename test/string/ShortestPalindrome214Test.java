package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/26
 */
public class ShortestPalindrome214Test {

    private ShortestPalindrome214 shortestPalindrome = new ShortestPalindrome214();

    @Test
    public void test1() {
        String s = shortestPalindrome.shortestPalindrome("aabc");
        Assert.assertEquals(s, "cbaabc");
    }

    @Test
    public void test2() {
        String s = shortestPalindrome.shortestPalindrome("abcd");
        Assert.assertEquals(s, "dcbabcd");
    }

    @Test
    public void test3() {
        String s = shortestPalindrome.shortestPalindrome("aacecaaa");
        Assert.assertEquals(s, "aaacecaaa");
    }

    @Test
    public void test4() {
        String s = shortestPalindrome.shortestPalindrome("a");
        Assert.assertEquals(s, "a");
    }

    @Test
    public void test5() {
        String s = shortestPalindrome.shortestPalindrome("ab");
        Assert.assertEquals(s, "bab");
    }

    @Test
    public void test6() {
        String s = shortestPalindrome.shortestPalindrome("abc");
        Assert.assertEquals(s, "cbabc");
    }
}
