package stack;


import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/01/25
 */
public class Calculate227 {

    /**
     * 这个问题主要是使用String的replace(" ")方法和Stack。
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        int len = s.length(), num = 0;
        char ch;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == len - 1) {
                if (sign == '+') {
                    numStack.push(num);
                } else if (sign == '-') {
                    numStack.push(-num);
                } else if (sign == '*') {
                    numStack.push(numStack.pop() * num);
                } else if (sign == '/') {
                    numStack.push(numStack.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }
        int result = 0;
        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;
    }

    public int calculateI(String s) {
        int curNum = 0, lastNum = 0, result = 0;
        char lastOperator = '+';
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                curNum = curNum * 10 + (ch - '0');
            } else if(ch == '+' || ch == '-') {
                if(lastOperator == '+') {
                    result += curNum;
                } else if(lastOperator == '-') {
                    result -= curNum;
                } else if(lastOperator == '*') {
                    result += lastNum * curNum;
                } else {
                    result += lastNum / curNum;
                }
                curNum = 0;
                lastOperator = ch;
                lastNum = 0;
            } else if(ch == '*' || ch == '/') {
                if(lastOperator == '+') {
                    lastNum = curNum;
                } else if(lastOperator == '-') {
                    lastNum = -curNum;
                } if(lastOperator == '*') {
                    lastNum = lastNum * curNum;
                } else if(lastOperator == '/') {
                    lastNum = lastNum / curNum;
                }
                curNum = 0;
                lastOperator = ch;
            }
            //空字符串不做处理
        }
        if(lastOperator == '+') {
            result += curNum;
        } else if(lastOperator == '-') {
            result -= curNum;
        } else if(lastOperator == '*') {
            result += lastNum * curNum;
        } else {
            result += lastNum / curNum;
        }
        return result;
    }
}
