package dp;

/**
 * LeetCode712
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 * @author baitao zou
 * date 2020/05/29
 */
public class MinimumDeleteSum712 {

    /**
     * 参考LeetCode72、LeetCode583、LeetCode1035
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        return minimumDeleteSumByOneDimensionDP(s1, s2);
    }

    /**
     * 二维动态规划
     * 递推公式
     * 如果：s1.charAt(i-1) == s2.charAt(j-1)，dp[i][j] = dp[i-1][j-1];
     * 如果：s1.charAt(i-1) != s2.charAt(j-1). dp[i][j] = Math.min(dp[i-1][j-1]+s1.charAt(i-1)+s2.charAt(j-1),Math.min(dp[i-1][j]+s1.charAt(i),dp[i][j-1]+s2.charAt(j)));
     *
     * @param s1
     * @param s2
     * @return
     */
    private int minimumDeleteSumByTwoDimensionDP(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] += s1.charAt(i - 1) + dp[i - 1][0];
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] += s2.charAt(j - 1) + dp[0][j - 1];
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + ch1 + ch2, Math.min(dp[i - 1][j] + ch1, dp[i][j - 1] + ch2));
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 一维动态规划
     *
     * @param s1
     * @param s2
     * @return
     */
    private int minimumDeleteSumByOneDimensionDP(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[] first = new int[len2 + 1];
        for (int i = 1; i <= len2; i++) {
            first[i] = first[i - 1] + s2.charAt(i - 1);
        }

        int[] second = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            second[0] = first[0] + s1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);
                if (ch1 == ch2) {
                    second[j] = first[j - 1];
                } else {
                    second[j] = Math.min(first[j - 1] + ch1 + ch2, Math.min(first[j] + ch1, second[j - 1] + ch2));
                }
            }
            int[] tmp = first;
            first = second;
            second = tmp;
        }
        return first[len2];
    }
}
