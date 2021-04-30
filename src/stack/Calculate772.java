package stack;

/**
 * @author Baitao Zou
 * date 2021/03/13
 */
public class Calculate772 {
    private int index = 0;

    public int calculate(String s) {
        int curNum = 0, lastNum = 0, result = 0;
        char lastOperator = '+';
        while (index < s.length()) {
            char ch = s.charAt(index);
            ++index;
            if (ch >= '0' && ch <= '9') {
                curNum = curNum * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                if (lastOperator == '+') {
                    result += curNum;
                } else if (lastOperator == '-') {
                    result -= curNum;
                } else if (lastOperator == '*') {
                    result = lastNum * curNum;
                } else {
                    result = lastNum / curNum;
                }
                curNum = 0;
                lastNum = 0;
                lastOperator = ch;
            } else if (ch == '*' || ch == '/') {
                if (lastOperator == '+') {
                    lastNum = curNum;
                } else if (lastOperator == '-') {
                    lastNum = -curNum;
                } else if (lastOperator == '*') {
                    lastNum = lastNum * curNum;
                } else {
                    lastNum = lastNum / curNum;
                }
                curNum = 0;
                lastOperator = ch;
            } else if (ch == '(') {
                curNum = calculate(s);
            }
        }
        if (lastOperator == '+') {
            result += curNum;
        } else if (lastOperator == '-') {
            result -= curNum;
        } else if (lastOperator == '*') {
            result = lastNum * curNum;
        } else {
            result = lastNum / curNum;
        }
        return result;
    }
}
