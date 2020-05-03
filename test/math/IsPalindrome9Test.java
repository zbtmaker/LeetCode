package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/10
 */
public class IsPalindrome9Test {
    private IsPalindrome9 palindrome = new IsPalindrome9();

    @Test
    public void test1() {
        boolean result = palindrome.isPalindrome(121);
        Assert.assertTrue(result);
    }


    @Test
    public void test2() {
        boolean result = palindrome.isPalindrome(1);
        Assert.assertTrue(result);
    }


    @Test
    public void test3() {
        boolean result = palindrome.isPalindrome(12);
        Assert.assertFalse(result);
    }


    @Test
    public void test4() {
        boolean result = palindrome.isPalindrome(-121);
        Assert.assertFalse(result);
    }

    @Test
    public void test5() {
        boolean result = palindrome.isPalindrome(10);
        Assert.assertFalse(result);
    }

    @Test
    public void test6() {
        boolean result = palindrome.isPalindrome(100);
        Assert.assertFalse(result);
    }

    @Test
    public void test7() {
        boolean result = palindrome.isPalindrome(1001);
        Assert.assertTrue(result);
    }

    @Test
    public void test8(){
        boolean result = palindrome.isPalindrome(22);
        Assert.assertTrue(result);
    }

    @Test
    public void test9(){
        boolean result = palindrome.isPalindrome(100);
        Assert.assertFalse(result);
    }
}
