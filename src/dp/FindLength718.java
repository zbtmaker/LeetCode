package dp;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\21 0021.
 * 题目描述：给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。这里需要的是连续的公共子串
 */
public class FindLength718 {
    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度
     *
     * @param A 给定的第一个数组
     * @param B 给定的第二个数组数组
     * @return 两个数组公共子串的长度
     */
    public int findLength(int[] A, int[] B) {
        int len1 = A.length, len2 = B.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public int findLengthByCompress(int[] A, int[] B) {
        int len1 = A.length, len2 = B.length;
        int[] cur = new int[len2 + 1], last = new int[len2 + 1];
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (A[i - 1] == B[j - 1]) {
                    cur[j] = last[j - 1] + 1;
                    max = Math.max(max, cur[j]);
                }
            }
            last = cur;
            Arrays.fill(cur, 0);
        }
        return max;
    }
}
