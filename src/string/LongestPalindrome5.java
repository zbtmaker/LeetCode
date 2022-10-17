package string;

/**
 * Created by Administrator on 2019\1\23 0023.
 */
public class LongestPalindrome5 {

    public String longestPalindrome(String s) {
        return longestPalindromeByManacher(s);
        /*return longestPalindromeByDynamicProgramming(s);*/
    }

    /**
     * 动态规划也是能够通过这道题的，但是这样做的时间复杂度和空间复杂度稍微有些高。time complexity O(N^2),
     * space complexity O(N^2)。相比较Manacher算法，这种动态规划解决最长回文串的问题会比较容易理解。这个题目我们
     * 可以加以改编一下，就是求解所有的最长回文子串，不要求顺序。
     * 分析过程：
     * 最长回文字符串的判断这个思想虽然简单的只有一个字符串，但是这个问题和最长公共子串和
     * 最长公共子序列一样，我们都需要一个二维数组dp来记录已经判断是回文的子串。假设给定的
     * 字符串索引i,j，其中s.substring(i,j+1)如果是回文，那么我们就用dp(i,j) = j - i + 1;
     * 如果0 <= i < j <= s.length-1,不是回文，那么dp(i,j) = 0;
     * 如果0 <= i == j <= s.length-1,此时表示长度为1，那么dp(i,i) = 1;
     * 那么对于任意的索引 0 <= i < j <= s.length -1,我们如何判断是否是回文呢，其实我们只需要判断
     * flag = (s.charAt(i) == s.charAt(j)) && (s.substring(i+1,j)是一个回文)
     * 如果flag == true , dp(i,j) = dp(i+1,j-1) + 2;
     * 如果flag == false，那么dp(i,j) = 0;
     * 2、所以我们最终就是要找到最长回文的leftIndex和rightIndex以及max值。每次我们发现一个新的回文，
     * 我们都会拿新的回文和之前的最长回文长度max进行比较，如果新的回文长度大于max,则更新leftIndex和
     * rightIndex。
     * 3、我们最终返回s.substring(leftIndex,rightIndex + 1)就可以了。
     * 以上就是对最长回文子串的分析过程，其实发现这个分析过程和最长公共子序列很像，有一些相同的地方。同样的
     * 对于最长回文子序列和最长公共子序列的思想应该类似，可以一起做了。
     *
     * @return
     */
    private String longestPalindromeByDynamicProgramming(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int max = 1;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        dp[i][j] = 2;
                    } else if (dp[i + 1][j - 1] > 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    leftIndex = i;
                    rightIndex = j;
                }
            }
        }
        return s.substring(leftIndex, rightIndex + 1);
    }

    /**
     * 通过Manacher算法实现最长回文字符串的判断
     *
     * @param s
     * @return
     */
    private String longestPalindromeByManacher(String s) {
        if (s.length() < 1) {
            return "";
        }
        StringBuilder sb = Manacher.preManacher(s);
        int[] radius = Manacher.manacher(sb);
        int max = 0;
        int index = -1;

        for (int i = 0; i < radius.length; i++) {
            if (max < radius[i]) {
                max = radius[i];
                index = i;
            }
        }

        return sb.substring(index - max + 1, index + max - 1).replaceAll("#", "");
    }
}
