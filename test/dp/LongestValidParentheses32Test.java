package dp;

import dp.LongestValidParentheses32;
import org.junit.Assert;
import org.junit.Test;

/**
 * 最长有效括号测试类
 *
 * @author Baitao Zou
 * date 2019/10/05
 */
public class LongestValidParentheses32Test {
    public static LongestValidParentheses32 parentheses32 = new LongestValidParentheses32();

    @Test
    public void test1() {
        int maxLen = parentheses32.longestValidParentheses(")()");
        Assert.assertEquals(maxLen, 2);
    }

    @Test
    public void test2() {
        int maxLen = parentheses32.longestValidParentheses("(()");
        Assert.assertEquals(maxLen, 2);
    }

    @Test
    public void test3() {
        int maxLen = parentheses32.longestValidParentheses("(()())");
        Assert.assertEquals(maxLen, 6);
    }

    @Test
    public void test4() {
        int maxLen = parentheses32.longestValidParentheses("(()()))()()()())");
        Assert.assertEquals(maxLen, 8);
    }

    @Test
    public void test5() {
        int maxLen = parentheses32.longestValidParentheses("()(()");
        Assert.assertEquals(maxLen, 2);
    }

    @Test
    public void test6() {
        int maxLen = parentheses32.longestValidParentheses("()(())");
        Assert.assertEquals(maxLen, 6);
    }
}
