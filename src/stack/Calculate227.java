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
        String str = replaceBlank(s);
        if (str.length() == 0) {
            return 0;
        }
        int len = str.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> strStack = new Stack<>();
        int i = 0;
        while (i < len) {
            int k = i + 1;
            while (k < len && str.charAt(k) >= '0' && str.charAt(k) <= '9') {
                k++;
            }
            String subString = str.substring(i, k);
            int curNum = Integer.parseInt(subString);
            if (!strStack.isEmpty()) {
                char ch = strStack.peek();
                if (ch == '*') {
                    strStack.pop();
                    int preNum = numStack.pop();
                    numStack.push(preNum * curNum);
                } else if (ch == '/') {
                    strStack.pop();
                    int preNum = numStack.pop();
                    numStack.push(preNum / curNum);
                } else if (ch == '-') {
                    numStack.push(-curNum);
                    strStack.pop();
                    strStack.push('+');
                } else {
                    numStack.push(curNum);
                }
            } else {
                numStack.push(curNum);
            }

            i = k;
            if (i >= len) {
                break;
            }
            char ch = str.charAt(i);
            strStack.push(ch);
            i++;
        }
        if (strStack.isEmpty()) {
            return numStack.pop();
        }
        while (!numStack.isEmpty() && !strStack.isEmpty()) {
            char character = strStack.pop();
            int curNum = numStack.pop();
            int preNum = numStack.pop();
            if (character == '+') {
                numStack.push(curNum + preNum);
            } else if (character == '-') {
                numStack.push(preNum - curNum);
            } else if (character == '*') {
                numStack.push(preNum * curNum);
            } else if (character == '/') {
                numStack.push(preNum / curNum);
            }
        }
        return numStack.pop();
    }

    /**
     * 这个方法用来取代字符串中的Blank
     *
     * @param str 字符串
     * @return 无空字符的字符串
     */
    private String replaceBlank(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
