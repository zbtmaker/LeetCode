package string;

/**
 * @author baitao zou
 * date 2020/04/27
 */
public class MinDistance583 {
    /**
     * 这个题目是最长共共子序列的一个扩展，我们只要找到word1和word2最长公共子序列，然后将那些不是共公的字符串
     * 删掉就可以了，这里我实现了一维的动态规划和二维的动态规划。同时也可以优化一下
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return minDistanceByOneDimensionDP(word1, word2);
    }

    /**
     * @param word1
     * @param word2
     * @return
     */
    private int minDistanceByTwoDimensionDP(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return len1 + len2 - (dp[len1][len2] << 1);
    }

    private int minDistanceByOneDimensionDP(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp1 = new int[len2 + 1];
        int[] dp2 = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp2[j] = dp1[j - 1] + 1;
                } else {
                    dp2[j] = Math.max(dp1[j], dp2[j - 1]);
                }
            }
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }
        return len1 + len2 - (dp1[len2] << 1);
    }
}
