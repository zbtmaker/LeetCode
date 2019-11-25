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
        int last = 0;
        int maxLen = 0;
        int len = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                boolean empty = stack.isEmpty();
                if (empty) {
                    len = 0;
                    continue;
                }
                char tmpChar = stack.pop();
                if (tmpChar == '(') {
                    len += 2;
                    if(empty){
                        len = len + last;
                    }
                } else {
                    len = 0;
                }
                maxLen = Math.max(len, maxLen);
            } else {
                stack.push(ch);
            }
        }
        return maxLen;
    }
}
