package string;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 链接：https://leetcode-cn.com/problems/decode-string
 *
 * @author baitao zou
 * date 2020/02/21
 */
public class DecodeString394 {

    /**
     * 字符串解码: 其实这个题目考察对栈掌握的情况, 但是这里有一个难点就是我们如何确定入栈和出栈的规则。z
     * 这个其实和加法有些像似。这里需要注意的是我们什么字符应该入栈，例如'['字符就应该进入stack。
     * 什么时候该出栈，以及出栈之后，是否还需要进一步继续出栈，然后入栈的问题。其实这里面就是应该写个test
     * case, 然后进行归纳总结.
     *
     * test example s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
     * i = 0; ch = "3"; numStack = 3; strStack = Empty;
     * i = 1; ch = "["; numStack = {3}; strStack = {"["};
     * i = 2; ch = "z"; numStack = {2, 3}; strStack = {"z", "["};
     * i = 3; ch = "]"; numStack = {3}; strStack = {},此时numStack执行numStack.pop(), numStack = {}, strStack执行出栈两次, 此时 "z" 出栈, 然后"["出战栈; strStack = {},此时result.append(str);
     * i = 4; ch = "2"; numStack = {2}; strStack = {},
     * i = 5; ch = "["; numStack = {2}; strStack = {"["}
     * i = 6; ch = "2"; numStack = {2, 2}; strStack = {"["};
     * i = 7; ch = "["; numStack = {2, 2}; strStack = {"[", "["};
     * i = 8; ch = "y"; numStack = {2, 2}; strStack = {"y", "[", "["};
     * i = 9; ch = "]"; 此时numStack.pop(), strStack.pop(); strStack.pop(); 发现!strStack.isEmpty,此时strStack.peek() == "[";那么此时要执行一次strStack.push(str);numStack = {2}, strStack = {"yy", "["}
     * i = 10\11; ch = "pq"; I: 判断下一个元素是否是"]",a.是，则直接添加到strStack中, b不是，b1:判断strStack.isEmpty, result.append(str);
     *                          b2不是，如果strStack.peek() == "[";strStack.push(str),否则，strStack.push(strStack.pop() + str);
     *                          numStack = {2}, strStack = {"yypq", "["}
     * i = 12; ch = "4", numStack = {"4", "2"}, strStack = {"yypq", "["}
     * i = 13; ch = "[", numStack = {"4", "2"}, strStack = {"[", "yypq", "["}
     * i = 14; ch = "2", numStack = {"2", "4", "2"}, strStack = {"[", "yypq", "["}
     * i = 15; ch = "[", numStack = {"2", "4", "2"}, strStack = {"[", "[", "yypq", "["}
     * i = 16\17; ch = "jk", numStack = {"2", "4", "2"}, strStack = {"jk", "[", "[", "yypq", "["}
     * j = 18; ch = "]", numStack = {"4", "2"}, strStack = {"jkjk", "[", "yypq", "["};
     * i = 19; ch = "e", numStack = {"4", "2"}, strStack = {"jkjke", "[", "yypq", "["};
     * i = 20; ch = "1"; numStack = {"1", "4", "2"}, strStack = {"jkjke", "[", "yypq", "["};
     * i = 21; ch = "["; numStack = {"1", "4", "2"}, strStack = {"[", "jkjke", "[", "yypq", "["};
     * i = 22; ch = "f"; numStack = {"1", "4", "2"}, strStack = {"f", "[", "jkjke", "[", "yypq", "["};
     * i = 23; ch = "]"; numStack = {"4", "2"}, strStack = {"jkjkef", "[", "yypq", "["}
     * i = 24; ch = "]"; numStack = {"2}, strStack = {"yypqjkjkefjkjkefjkjkefjkjkef","["}
     * i = 25; ch = "]"; numStack = {}, strStack = {}, result = "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkef"
     * i = 26/27; ch = "ef", numStack = {}, strStack ={}, result = zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef;
     *
     * @param s 编码数组
     * @return 解析后的字符串
     */
    public String decodeString(String s) {
        if (s == null) {
            return null;
        }
        int i = 0;
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        char ch;
        String str;
        while (i < s.length()) {
            ch = s.charAt(i);
            if (ch == '[') {
                strStack.push("[");
                i++;
            } else if (ch == ']') {
                int num = numStack.pop();
                str = strStack.pop();
                strStack.pop();
                StringBuilder sb = new StringBuilder(num * str.length());
                for (int m = 0; m < num; m++) {
                    sb.append(str);
                }
                if (strStack.isEmpty()) {
                    result.append(sb.toString());
                } else if (strStack.peek() == "[") {
                    strStack.push(sb.toString());
                } else {
                    String tmpStr = strStack.pop();
                    tmpStr = tmpStr + sb.toString();
                    strStack.push(tmpStr);
                }
                i++;
            } else if (ch >= '0' && ch <= '9') {
                int j = i;
                while (ch >= '0' && ch <= '9') {
                    j++;
                    ch = s.charAt(j);
                }
                int num = Integer.parseInt(s.substring(i, j));
                numStack.push(num);
                i = j;
            } else {
                int k = i;
                ch = s.charAt(k);
                while ((ch < '0' || ch > '9') && ch != ']') {
                    k++;
                    if (k == s.length()) {
                        break;
                    }
                    ch = s.charAt(k);
                }
                str = s.substring(i, k);
                if (strStack.isEmpty() || k == s.length()) {
                    result.append(str);
                } else {
                    if (strStack.peek().equals("[")) {
                        strStack.push(str);
                    } else {
                        String tmpStr = strStack.pop();
                        tmpStr = tmpStr + str;
                        strStack.push(tmpStr);
                    }
                }
                i = k;
            }
        }
        return result.toString();
    }
}
