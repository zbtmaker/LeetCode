package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/28
 */
public class IsMatch10Test {

    private IsMatch10 isMatch = new IsMatch10();

    @Test
    public void test1() {
        boolean flag = isMatch.isMatch("aa", "a*");
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        boolean flag = isMatch.isMatch("aa", "*a");
        Assert.assertFalse(flag);
    }

    @Test
    public void test3() {
        boolean flag = isMatch.isMatch("aa", "*a*");
        Assert.assertTrue(flag);
    }

    @Test
    public void test4() {
        boolean flag = isMatch.isMatch("aba", "*ab**a");
        Assert.assertTrue(flag);
    }

    @Test
    public void test5() {
        boolean flag = isMatch.isMatch("ab", ".*");
        Assert.assertTrue(flag);
    }

    @Test
    public void test6() {
        boolean flag = isMatch.isMatch("aab", "c*a*b");
        Assert.assertTrue(flag);
    }

    @Test
    public void test7() {
        boolean flag = isMatch.isMatch("mississippi", "mis*is*p*.");
        Assert.assertFalse(flag);
    }

    @Test
    public void test8() {
        boolean flag = isMatch.isMatch("mississsp", "mis*is*p");
        Assert.assertTrue(flag);
    }

    @Test
    public void test9() {
        boolean flag = isMatch.isMatch("mississsp", "");
        Assert.assertFalse(flag);
    }

    @Test
    public void test10() {
        boolean flag = isMatch.isMatch("", "*asa");
        Assert.assertFalse(flag);
    }

    @Test
    public void test11() {
        boolean flag = isMatch.isMatch("ab", ".*c");
        Assert.assertFalse(flag);
    }

    @Test
    public void test12() {
        boolean flag = isMatch.isMatch("", "c*a*");
        Assert.assertTrue(flag);
    }

    @Test
    public void test13() {
        boolean flag = isMatch.isMatch("", "c*ab*");
        Assert.assertFalse(flag);
    }

    @Test
    public void test14() {
        boolean flag = isMatch.isMatch("", "*a");
        Assert.assertFalse(flag);
    }

    @Test
    public void test15() {
        boolean flag = isMatch.isMatch("mississssp", "mis*is*p**");
        Assert.assertTrue(flag);
    }

    @Test
    public void test16() {
        boolean flag = isMatch.isMatch("aaa", "ab*ac*a");
        Assert.assertTrue(flag);
    }
}
