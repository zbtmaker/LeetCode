package string;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * tag: palindrome、dynamic programming
 *
 * @author baitao zou
 * date 2020/04/14
 */
public class LongestPalindromeSubseq516 {

    /**
     * 采用动态规划算法，
     * 如果说最长回文子序列LongestPalindrome5对应的是经典的最长公共子序列思想，
     * 那么最长回文子串LongestPalindromeSuseq516的对应的就是最长公共子串的思想。
     * 对于最长公共子串和最长公共子序列之间的不同就在于：给定字符串String str1、str2，我们给定
     * 索引i,j表示从i->j的一个子串，最长公共子序列的思路是，如果碰到一个不想等的字符串，那么公共
     * 字符串长度就清零，但是最长公共子序列的思路是，如果碰到不想等的字符，我们仍然要记录前一个位置
     * 的长度。
     * 与最长公共子序列和最长公共子串的区别一样，我们在解决最长回文子序列和最长回文子串的区别也在于此，
     * 一、对于任意的0 <= i < j <= s.length - 1我们可以列出最长回文子串的递推关系式：
     * dp(i,j)的最长回文串，如果s.charAt(i) == s.charAt(j),那么dp(i,j) = dp(i+1,j-1) + 2;
     * 如果s.charAt(i) != s.charAt(j),那么就dp(i,j) = max{dp(i,j-1),dp(i+1,j)}.
     * 二、对于特殊的位置，0 <= i == j <=s.length -1。有下面的关系
     * dp(i,j) = 1;
     * 根据上面两个一般和特殊的递推公式，我们就可以得到整个程序的递推公式，我们用一个max来表示最长回文子串的长度，
     * 最终只要返回这个max就可以了。
     * 三、这里还有一个点就是我们需要从i = s.length - 2开始，然后j 要从前往后走
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 <= j - 1 ? dp[i + 1][j - 1] + 2 : 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
