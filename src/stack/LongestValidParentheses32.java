package stack;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * @author Baitao Zou
 * date 2019/10/05
 */
public class LongestValidParentheses32 {
    /**
     * @param s 输入参数
     * @return 最长有效括号长度
     */
    public int longestValidParentheses(String s) {
        return longestValidParenthesesByDynamicProgramming(s);
    }

    /**
     * 因为要找到最长的有效括号，对于这种最值问题，而且是中间因为某种不合法的元素导致
     * 这种连续中断，就和我们之前做过的最长公共子串的问题一样可以使用动态规划的方式实现。
     * 如果使用动态规划思想，那么就需要找到sub-problem和parent-problem
     * （小问题和大问题之间的关系）。那么我们就需要找到一个父问题和子问题的递推关系。
     * 我们可以找到几种情况来看一下父问题和子问题之间是一个什么样的关系。如果是连续满足
     * '('和')',那么满足"()"这个括号之前如果也是合法的，那么我们就在之前的合法长度基础上
     * +2就可以了，如果之前因为一个")"不满足条件，那么这个位置的最长合法的长度就是0。
     * 1、如果"()()"模式，第二"()"，也就是s.charAt(i) = ')',而s.charAt(i-1) = '('
     * 此时就是aux[i] = aux[i - 2] + 2.
     * 2、如果"(())"模式，外层的"()"，也就是s.charAt(i - aux[i - 1] - 1) == '(',
     * 此时aux[i] = aux[i - 1] + (i - aux[i- 1] - 2 > 0? aux[i - aux[i - 1] - 2] : 0)+ 2;
     *
     * @param s 字符串
     * @return 最长字符串长度
     */
    private int longestValidParenthesesByDynamicProgramming(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] aux = new int[len];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    aux[i] = i > 2 ? aux[i - 2] + 2 : 2;
                } else if (i - aux[i - 1] - 1 >= 0 && s.charAt(i - aux[i - 1] - 1) == '(') {
                    aux[i] = aux[i - 1] + (i - aux[i- 1] - 2 > 0? aux[i - aux[i - 1] - 2] : 0)+ 2;
                }
                max = Math.max(max, aux[i]);
            }
        }
        return max;
    }
}
