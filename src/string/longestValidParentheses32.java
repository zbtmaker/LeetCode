package string;

import java.util.Stack;

/**
 * Created by Administrator on 2019\3\18 0018.
 */
public class longestValidParentheses32 {
    public static void main(String[] args){
        String s = "((())()";
        int len = new longestValidParentheses32().longestValidParentheses(s);
        System.out.println(len);
    }
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int lastLen = 0;
        int curLen = 0;
        int maxLen = 0;
        int lastSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (stack.size() == 0) {
                curLen = 0;
                lastLen = 0;
            } else if (stack.pop() == '(') {
                curLen += 2;
                if (lastSize == stack.size()) {
                    curLen += lastLen;
                    if (maxLen < lastLen) {
                        maxLen = lastLen;
                    }
                    lastLen = curLen;
                } else {
                    if (maxLen < curLen) {
                        maxLen = curLen;
                    }
                    lastSize = stack.size();
                    lastLen = 0;

                }
                curLen = 0;
            }

        }
        return maxLen;
    }
}
