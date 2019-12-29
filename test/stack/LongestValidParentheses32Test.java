package stack;

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
    public void test1(){
        String str = ")()";
        int maxLen = parentheses32.longestValidParentheses(str);
        Assert.assertEquals(maxLen,2);
    }

    @Test
    public void test2(){
        String str = "(()";
        int maxLen = parentheses32.longestValidParentheses(str);
        Assert.assertEquals(maxLen,2);
    }
    @Test
    public void test3(){
        String str = "(()())";
        int maxLen = parentheses32.longestValidParentheses(str);
        Assert.assertEquals(maxLen,6);
    }
}
