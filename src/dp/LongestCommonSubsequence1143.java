package dp;

/**
 * @author baitao zou
 * date 2020/04/16
 */
public class LongestCommonSubsequence1143 {

    /**
     * 最长公共子序列问题，要定义一下子序列和子串，子串表示连续的字符串，子序列表示
     * 不连续的字符串。
     * 对于最长公共子串问题可以参考算法导论中的最长公共子串问题，与这个的最大区别就是碰到
     * text1.charAt(i) != text2.charAt(j),最长公共子串的dp[i][j] = 0;
     * 而最长公共子序列
     * text1.charAt(i) != text2.charAt(j),此时公共子串的dp[i][j] = min{dp[i][j-1],dp[i-1][j}
     *
     * @param text1 字符1
     * @param text2 字符2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceByOneDimensionDP(text1, text2);
    }

    /**
     * 使用二维数组实现最长共公子序列
     * @param text1
     * @param text2
     * @return
     */
    private int longestCommonSubsequenceByTwoDimensionDP(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 使用两个一维数组实现了最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    private int longestCommonSubsequenceByOneDimensionDP(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        int[] dp1 = new int[len2 + 1];
        int[] dp2 = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp2[j] = dp1[j - 1] + 1;
                } else {
                    dp2[j] = Math.max(dp1[j], dp2[j - 1]);
                }
            }
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }
        return dp1[len2];
    }
}
