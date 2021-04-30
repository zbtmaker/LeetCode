package stack;

import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/05/01
 */
public class Calculate224 {
    /**
     * 如果碰到了'(',那么这个时候下一个元素可能是数字'0'～'9'，也有可能是'-'。
     * 如果碰到了数字，那么指针就需要继续往下走，直到不再是数字。
     * 如果碰到了'+'、'-'，那么应该怎么办，遇到'+'、'-'都是要
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int len = s.length(), result = 0, num = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                num = num * sign;
                result += num;
                sign = 1;
                num = 0;
            } else if (ch == '-') {
                num = num * sign;
                result += num;
                sign = -1;
                num = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                num = 0;
            } else if (ch == ')') {
                result += sign * num;
                result = result * stack.pop();
                result += stack.pop();
                num = 0;
                sign = 1;
            }
        }
        return result + sign * num;
    }

    private int index = 0;

    public int calculateI(String s) {
        int curNum = 0, result = 0;
        char lastOperator = '+';
        while (index < s.length()) {
            char ch = s.charAt(index);
            index++;
            if (ch == ')') {
                break;
            }
            if (ch >= '0' && ch <= '9') {
                curNum = curNum * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                if (lastOperator == '+') {
                    result += curNum;
                } else {
                    result -= curNum;
                }
                lastOperator = ch;
                curNum = 0;
            } else if (ch == '(') {
                curNum = calculateI(s);
            }
        }
        if (lastOperator == '+') {
            result += curNum;
        } else {
            result -= curNum;
        }
        return result;
    }
}
