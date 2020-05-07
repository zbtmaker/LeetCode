package dp;

/**
 * Created by Administrator on 2019\3\6 0006.
 * 这个问题参考ClimbStairs70问题。
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 */
public class NumDecodings91 {

    public int numDecodings(String s) {
        return numDecodingsByDPConstant(s);
    }

    /**
     * 这个题目使用回溯的方式来解决，对于任意一个位置，要么取一位，要么取两位。
     * 同时，如果去两位不成，那么直接返回，取一位的时候如果发现这个位是零，那么发现实行不通的则返回。
     *
     * @param s
     * @return
     */
    private int numDecodingsByBacktracking(String s) {
        int[] count = new int[]{0};
        recurNumDecodings(s, 0, count);
        return count[0];
    }

    private void recurNumDecodings(String s, int index, int[] count) {
        if (index >= s.length()) {
            count[0] += 1;
            return;
        }

        //caseI 每一个位置取1位

        int num1 = s.charAt(index) - '0';
        if (num1 < 1 || num1 > 26) {
            return;
        }
        recurNumDecodings(s, index + 1, count);

        //caseII 每一个位置取两位
        if (index + 1 >= s.length()) {
            return;
        }
        int num2 = Integer.parseInt(s.substring(index, index + 2));
        if (num2 < 1 || num2 > 26) {
            return;
        }
        recurNumDecodings(s, index + 2, count);
    }

    /**
     * 这里需要判断一种情况就是，
     * 首先我们要理清则是一个什么样的问题，是一个组合问题还是排列问题。
     * step1：定义aux[i]数组用于表示长度为i的字符串能够有多少中表示类型。
     * step2：找到aux[i]和aux[i-1]和aux[i-2]之间的关系，对于step2的定义今天晚上完成
     * {1,{2,3}},{{1,2},3}
     * step3：定义初始值，i=0表示长度为0时，有多少种表示方法，自然是aux[0] = 0
     * 当i=1时，表示长度为1的字符串s有多少种表示方法，自然是aux[1] = s.charAt(i-1) == '0' ? 0 : 1.
     * 其实这个题目和爬楼梯是一个性质的吧。走一步还是走两步，走一步是否可行，走两步是否可行。
     * <p>
     * 这里采用一维数组解决DP问题
     *
     * @param s
     * @return
     */
    private int numDecodingsByDPOneDimension(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] aux = new int[len + 1];
        aux[0] = 1;
        aux[1] = 1;
        for (int i = 2; i <= len; i++) {
            char curChar = s.charAt(i - 1);
            char lastChar = s.charAt(i - 2);
            if (curChar == '0') {
                if (lastChar > '0' && lastChar < '3') {
                    aux[i] = aux[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (lastChar == '0') {
                    aux[i] = aux[i - 1];
                } else if (lastChar == '1' || lastChar == '2' && curChar > '0' && curChar <= '6') {
                    aux[i] = aux[i - 2] + aux[i - 1];
                } else {
                    aux[i] = aux[i - 1];
                }
            }
        }
        return aux[len];
    }

    /**
     * 常数时间算法解决算法问题
     *
     * @param s
     * @return
     */
    private int numDecodingsByDPConstant(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int fir = 1;
        int sec = 1;
        for (int i = 2; i <= s.length(); i++) {
            char curChar = s.charAt(i - 1);
            char lastChar = s.charAt(i - 2);
            int tmp = 0;
            if (curChar == '0') {
                if (lastChar > '0' && lastChar < '3') {
                    tmp = fir;
                } else {
                    return 0;
                }
            } else {
                if (lastChar == '0') {
                    tmp = sec;
                } else if (lastChar == '1' || lastChar == '2' && curChar > '0' && curChar <= '6') {
                    tmp = fir + sec;
                } else {
                    tmp = sec;
                }
            }
            fir = sec;
            sec = tmp;
        }
        return sec;
    }
}
