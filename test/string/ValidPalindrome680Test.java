package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/11
 */
public class ValidPalindrome680Test {
    private ValidPalindrome680 palindrome = new ValidPalindrome680();

    @Test
    public void test1() {
        boolean result = palindrome.validPalindrome("abc");
        Assert.assertFalse(result);
    }

    @Test
    public void test2() {
        boolean result = palindrome.validPalindrome("aba");
        Assert.assertTrue(result);
    }

    @Test
    public void test3() {
        boolean result = palindrome.validPalindrome("a");
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        boolean result = palindrome.validPalindrome("ab");
        Assert.assertTrue(result);
    }

    @Test
    public void test5() {
        boolean result = palindrome.validPalindrome("eccer");
        Assert.assertTrue(result);
    }

}
