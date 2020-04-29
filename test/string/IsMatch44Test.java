package string;

import dp.IsMatch44;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/27
 */
public class IsMatch44Test {

    private IsMatch44 isMatch = new IsMatch44();

    @Test
    public void test1() {
        boolean flag = isMatch.isMatch("aa", "a*a");
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        boolean flag = isMatch.isMatch("aa", "aa*");
        Assert.assertTrue(flag);
    }

    @Test
    public void test3() {
        boolean flag = isMatch.isMatch("aa", "a");
        Assert.assertFalse(flag);
    }

    @Test
    public void test4() {
        boolean flag = isMatch.isMatch("aa", "*");
        Assert.assertTrue(flag);
    }

    @Test
    public void test5() {
        boolean flag = isMatch.isMatch("cb", "?a");
        Assert.assertFalse(flag);
    }

    @Test
    public void test6() {
        boolean flag = isMatch.isMatch("adceb", "*a*b");
        Assert.assertTrue(flag);
    }

    @Test
    public void test7() {
        boolean flag = isMatch.isMatch("acdcb", "a*c?b");
        Assert.assertFalse(flag);
    }

    @Test
    public void test8() {
        boolean flag = isMatch.isMatch("acdcb", "ac***b");
        Assert.assertTrue(flag);
    }

    @Test
    public void test9() {
        boolean flag = isMatch.isMatch("", "");
        Assert.assertTrue(flag);
    }

    @Test
    public void test10() {
        boolean flag = isMatch.isMatch("", "**");
        Assert.assertTrue(flag);
    }

    @Test
    public void test11() {
        boolean flag = isMatch.isMatch("aab", "c*a*b");
        Assert.assertFalse(flag);
    }

    @Test
    public void test12() {
        boolean flag = isMatch.isMatch("mississippi", "m??*ss*?i*pi");
        Assert.assertFalse(flag);
    }
}
