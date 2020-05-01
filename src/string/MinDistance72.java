package string;

import java.util.Arrays;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 链接：https://leetcode-cn.com/problems/edit-distance
 *
 * @author baitao zou
 * date 2020/04/28
 */
public class MinDistance72 {

    /**
     * 对于字符串的问题，很多都是可以采用动态规划实现的，那么此题一样也是可以采用动态规划算法实现。
     * 动态规划三步走，第一步，定义目标转移矩阵；第二部，推导状态转移方程；第三部，定义初始值。
     * step1：word1的长度为len1，word2的长度为len2。定义二维矩阵dp = new int[len1][len2]，
     * 其中对于任意的0 <= i <= len1，0 <= j <= len2，dp[i][j]表示长度为i的word1字符串和长度为word2的字符串
     * 需要编辑的最小距离。
     * step2：对于任意的 1 <= i <= len1，0 <= j <= len2，我们来讨论ch1 = word1.charAt(i-1)和ch2 = word2.charAt(j-1)
     * 的关系，这里肯定是两种方式。
     * A、如果ch1 = ch2，那么此时word1的第i-1位和word2的j-1位肯定是不需要编辑的，那么这个时候我们只需要知道dp[i-1][j-1]的最小
     * 编辑距离是多少就好了。所以如果ch1 == ch2，那么dp[i][j] = dp[i-1][j-1]。
     * B、如果ch1 != ch2，那么此时word1的第i-1位和word2的j-1位肯定是需要编辑的，那么我们至少是要编辑一次了。但是这个编辑距离可以
     * 通过填表法知道dp[i][j]和dp[i-1][j-1]、dp[i-1][j]、dp[i][j-1]之间的关系。dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))
     * 综上两种情况最终可以得到转态转移方程。
     * step3：分别讨论word1 = ""和word2 = ""的情况得到dp[0][j]和dp[i][0]的值
     * A、word1 = ""，得到dp[0][j]，其中0 <= j <= len2。因为j表示word2的长度，因为word1的长度为0。如果我们想要通过删除word2的字符或者往word1插入字符使得word1 == word2，
     * 如果word2的长度为j，那么word1就要插入j次字符，或者是word2删除i次，因此对于0 <= j <= len2，dp[0][j] = j。
     * B、word2 = ""，得到dp[i][0]，其中0 <= i <= len1。因为i表示word1的长度，因为word2的长度等于0。如果我们想要通过往word2插入字符或者删除word1的字符使word1 == word2，
     * 如果word1的长度为i，那么word1就要删除i次，或者是word2插入i次字符，因此对于0 <= i <= len1，dp[i][0] = i。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return minDistanceByOneDimensionDP(word1, word2);
    }

    /**
     * 二维动态规划实现最小编辑距离
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceByTwoDimensionDP(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len1][len2];
    }

    /**
     * 一维动态规划实现最小编辑距离
     *
     * @param word1
     * @param word2
     * @return
     */
    private int minDistanceByOneDimensionDP(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp1 = new int[len2 + 1];
        int[] dp2 = new int[len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp1[i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            dp2[0] = i;
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp2[j] = dp1[j - 1];
                } else {
                    dp2[j] = Math.min(dp1[j - 1], Math.min(dp2[j - 1], dp1[j])) + 1;
                }
            }
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }
        return dp1[len2];
    }
}
