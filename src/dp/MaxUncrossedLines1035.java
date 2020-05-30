package dp;

/**
 * @author baitao zou
 * date 2020/05/29
 */
public class MaxUncrossedLines1035 {

    public int maxUncrossedLines(int[] A, int[] B) {
        return maxUncrossedLinesByTwoDimension(A, B);
    }

    /**
     * 具体的算法思路参考MinimumDeleteSum712
     */
    public int maxUncrossedLinesByTwoDimension(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenA][lenB];
    }
}
