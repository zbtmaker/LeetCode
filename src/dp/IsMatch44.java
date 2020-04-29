package dp;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/04/27
 */
public class IsMatch44 {

    /**
     * test case1 : p = "*a*d" s = "adced"
     * a  d  c  e  d
     * *  1  1  1  1  1
     * a  1  0  0  0  0
     * *  1  1  1  1  1
     * d  0  1  0  0  1
     * <p>
     * test case2 : s = "*ad*d" d = "adced"
     * a  d  c  e  d
     * *  1  1  1  1  1
     * a  1  0  0  0  0
     * d  0  1  0  0  0
     * *  0  1  1  1  1
     * d  0  0  0  0  1
     * 这个题目能够做出来，通过分析两个test case，第一个s="adced, p="*a*d"，第二个test case，s="*ad*d", p="adced".把这两个case通过
     * 填表法.
     * Step1 : 我们最终就能得出下面的递推公式
     * if p.charAt(i-1) == '*',这个时候我们需要判断的就是此时因为可以匹配后面所有的字符，
     * a.如果dp[i][j-1] = true，表明我们长度为i的字符串P能够匹配长度为j-1的字符串，且p.charAt(i-1) == '*'，所以s从j-1后面的字符也都是可以匹配上的。
     * b.如果dp[i-1][j-1] = true,表明长度为p的字符是完全可以匹配长度为为j-1的字符串的，
     * c.如果dp[i-1][j] = true，表明所有的长度为i-1的字符串p可以匹配长度为j的字符串j，由于'*'可以匹配任何字符串，也包括空字符串，那么这个'*'就可以充当一个空字符串。
     * 且p.charAt(i - 1) == '*'，从题意中我们可以看到这个是可以匹配任意字符串的，因此p.charAt(i) == s.charAt(j).
     * 因此，长度为i的p字符串和长度为j的字符串肯定是能够匹配的
     * 综合上面的a和，可以得到 if p.charAt(i-1) == '*', dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j]
     * if p.charAt(i-1) == '.'，此时肯定有p.charAt(i-1) == s.charAt(j-1)，dp[i][j] = dp[i-1][j-1]
     * if p.charAt(i-1) == s.charAt(j-1)，此时dp[i][j] = dp[i-1][j-1]。
     * 综上所述，三种情况，我们其实就能够得到我们最终的一个递推关系式。
     * <p>
     * step2，需要确定初始值，这个很重要。
     * dp[0][j]表示长度为p字符串长度为0，j字符串长度为0时可以匹配，但是其他的都无法匹配
     * dp[j][0]表示长度为j的p字符串，能够匹配长度为零的s字符串的。
     *
     * @param s 字符串
     * @param p 模式
     * @return true-匹配成功 ｜ false-匹配失败
     */
    public boolean isMatch(String s, String p) {
        return isMatchByOneDimensionDP(s, p);
    }

    /**
     * 二维空间实现动态规划
     *
     * @param s 待匹配字符串
     * @param p 模式字符串
     * @return true-匹配 ｜ false-不匹配
     */
    private boolean isMatchByTwoDimensionDP(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenP + 1][lenS + 1];
        dp[0][0] = true;
        int i = 1;
        while (i <= lenP) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            Arrays.fill(dp[i], true);
            i++;
        }
        for (; i <= lenP; i++) {
            char charP = p.charAt(i - 1);
            for (int j = 1; j <= lenS; j++) {
                if (charP == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                } else if (charP == '?' || charP == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[lenP][lenS];
    }

    /**
     * 一维动态规划数组实现，这里需要注意的是如果p.charAt(i) != s.charAt(j)这里需要设置为dp2[j]=false.
     * 因为dp1和dp2交换以后，dp2还存留着dp1之前的值为true，但其实每一次循环的时候，dp2数组应该是每一个位置
     * 都应该是false。
     *
     * @param s 待匹配字符串
     * @param p 模式字符串
     * @return true-匹配 ｜ false-不匹配
     */
    private boolean isMatchByOneDimensionDP(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[] dp1 = new boolean[lenS + 1];
        boolean[] dp2 = new boolean[lenS + 1];
        dp1[0] = true;
        int i = 1;
        while (i <= lenP) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            Arrays.fill(dp1, true);
            i++;
        }
        for (; i <= lenP; i++) {
            dp2[0] = false;
            char charP = p.charAt(i - 1);
            for (int j = 1; j <= lenS; j++) {
                if (charP == '*') {
                    dp2[j] = dp1[j - 1] || dp1[j] || dp2[j - 1];
                } else if (charP == '?' || charP == s.charAt(j - 1)) {
                    dp2[j] = dp1[j - 1];
                } else {
                    dp2[j] = false;
                }
            }
            boolean[] tmp = dp2;
            dp2 = dp1;
            dp1 = tmp;
        }
        return dp1[lenS];
    }
}
