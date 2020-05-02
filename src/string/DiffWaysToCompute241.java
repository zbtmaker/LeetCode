package string;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/05/02
 */
public class DiffWaysToCompute241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<String> strs = parseStr(input);
        return recursiveCompute(strs, 0, strs.size() - 1);
    }

    /**
     * 采用递归调用的方式实现，每碰到字符串数组中的运算符我们都需要进行对运算符的左边和右边进行递归。
     * 其实我们发现递归的时候会出现重复计算的问题。应该采用数组将中间计算结果存储起来才能避免重复计算。
     * tag：recursive
     *
     * @param strs
     * @param start
     * @param end
     * @return
     */
    private List<Integer> recursiveCompute(List<String> strs, int start, int end) {
        if (start == end) {
            return Collections.singletonList(Integer.parseInt(strs.get(start)));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            String operator = strs.get(i);
            if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
                List<Integer> lefts = recursiveCompute(strs, start, i - 1);
                List<Integer> rights = recursiveCompute(strs, i + 1, end);
                for (Integer left : lefts) {
                    for (Integer right : rights) {
                        switch (operator) {
                            case "+":
                                result.add(left + right);
                                break;
                            case "-":
                                result.add(left - right);
                                break;
                            case "*":
                                result.add(left * right);
                                break;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 解析字符串，将字符串拆分成数字、操作符字符串
     *
     * @param str
     * @return
     */
    private List<String> parseStr(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int k = i + 1;
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*') {
                strs.add(String.valueOf(str.charAt(i)));
            } else {
                while (k < str.length()
                        && str.charAt(k) >= '0'
                        && str.charAt(k) <= '9') {
                    k++;
                }
                strs.add(str.substring(i, k));
            }
            i = k;
        }
        return strs;
    }
}
