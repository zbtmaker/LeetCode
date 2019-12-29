package stack;

import java.util.Stack;

/**
 * 最长有效括号-堆栈
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
        if (null == s || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        Stack<Character> stack = new Stack<>();
        int len = 0;
        int lastLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
                len += 2;
            }
            if (stack.isEmpty()) {
                len += lastLen;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
