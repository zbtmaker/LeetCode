package string;


import java.util.LinkedList;

/**
 * Created by Administrator on 2019\3\31 0031.
 */
public class IsAdditiveNumber306 {
    /**
     * 1、暴力算法，主要是找到前面两个元素，现在已经是双指针实现了，下一次就是
     * 2、TODO 或许是采用Merge、Memorization、Dynamic Programming
     *
     * @param num 数组
     * @return true-是累加序列 ｜ false-不是累加序列
     */
    public boolean isAdditiveNumber(String num) {
        return isAdditiveNumberByBruteForce(num);
    }

    /**
     * 暴力算法:这个题目的暴力算法思想其实就是找到能够钱前面两个满足条件的数字，
     * 那么后面的就可以一直迭代就可以了，因此算法的time complexity O(N^2),
     * 空间复杂度为O(1).其中需要注意一些特殊case的优化操作。
     *
     * @param num 数组
     * @return 是否是累加序列, true-是 ｜ false-不是
     */
    private boolean isAdditiveNumberByBruteForce(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        int len = num.length() - 1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j > i + 1 && num.charAt(i + 1) == '0') || Math.max(i + 1, j - i) > len - j) {
                    break;
                }
                String str1 = num.substring(0, i + 1);
                String str2 = num.substring(i + 1, j + 1);
                String result = addStr(str1, str2);
                String str3 = num.substring(j + 1, j + 1 + result.length());
                int k = j + 1;
                while (result.equals(str3)) {
                    k = k + result.length();
                    if (k > len) {
                        return true;
                    }
                    str1 = str2;
                    str2 = str3;
                    result = addStr(str1, str2);
                    if (result.length() > len + 1 - k) {
                        break;
                    }
                    str3 = num.substring(k, k + result.length());
                }
            }
        }
        return false;
    }

    /**
     * 字符串相加
     *
     * @param str1 被加数
     * @param str2 加数
     * @return 和
     */
    private String addStr(String str1, String str2) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int res;
        int carry = 0;
        while (i > -1 && j > -1) {

            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            res = (ch1 - '0') + (ch2 - '0') + carry;
            carry = res / 10;
            list.addFirst(res % 10);
            i--;
            j--;
        }
        while (i > -1) {
            char ch1 = str1.charAt(i);
            res = (ch1 - '0') + carry;
            carry = res / 10;
            list.addFirst(res % 10);
            i--;
        }
        while (j > -1) {
            char ch1 = str2.charAt(j);
            res = (ch1 - '0') + carry;
            carry = res / 10;
            list.addFirst(res % 10);
            j--;
        }
        if (carry != 0) {
            list.addFirst(carry);
        }
        StringBuilder sb = new StringBuilder(list.size());
        for (Integer str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
