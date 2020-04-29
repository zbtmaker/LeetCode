package string;


import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/04/26
 */
public class ShortestPalindrome214 {

    /**
     * 这个题目要们在字符串的头部插入最少的字符使我们的字符串是一个回文字符串，我们需要做的就是
     * 找到一个以第一个元素开头的最长回文对，然后我们就需要将剩余的字符串翻转之后添加到当前字符串
     * 的头部，例如'aabc';以'a'开头的最长字符串是'aa', 此时我们需要将'bc'翻转之后为'cb'，然后
     * 将'cb'添加到'aabc'头部，最终最长的回文为'cbaabc'.
     * 采用二维数组的动态规划算法能够解决问题，但是对于数组较长的问题，会出现内存爆炸的问题出现。
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        return shortestPalindromeByOneDimensionDP(s);
    }

    private String shortestPalindromeByTwoDimensionDP(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] > 0 ? dp[i + 1][j - 1] + 2 : 0;
                    }
                }
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        int max = 1;
        int right = 0;
        for (int i = 1; i < len; i++) {
            if (max < dp[0][i]) {
                max = dp[0][i];
                right = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i > right; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * 其实我们这个题目是有目的的，我如何实现一个一维的动态规划来实现我们的回文判断。我在这里优化了最长回文的二维实现方式为
     * 一维。这里空间复杂度算是下降了，那么这个算法其实可以用在。
     *
     * @param s
     * @return
     */
    private String shortestPalindromeByOneDimensionDP(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            dp1[i] = 1;
            dp2[i + 1] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j - 1) {
                        dp1[j] = 2;
                    } else {
                        dp1[j] = dp2[j - 1] > 0 ? dp2[j - 1] + 2 : 0;
                    }
                } else {
                    dp1[j] = 0;
                }
            }
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }
        int max = 1;
        int right = 0;
        for (int i = 1; i < len; i++) {
            if (max < dp2[i]) {
                max = dp2[i];
                right = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i > right; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
}
