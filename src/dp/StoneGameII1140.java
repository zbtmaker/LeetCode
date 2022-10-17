package dp;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2020/12/26
 */
public class StoneGameII1140 {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + piles[i - 1];
        }
        int[][] F = new int[len + 1][len + 1];
        for (int[] f : F) {
            Arrays.fill(f, Integer.MIN_VALUE);
        }
        int result = negamax(prefixSum, 1, 1, F);
        return (result + prefixSum[len]) >> 1;
    }

    private int negamax(int[] prefixSum, int start, int m, int[][] F) {
        int len = prefixSum.length;
        if (start >= len) {
            return 0;
        }
        int max = F[start][m];
        if (max != Integer.MIN_VALUE) {
            return max;
        }
        int l = start + 2 * m;
        for (int i = start; i < l && i < len; i++) {
            max = Math.max(max, prefixSum[i] - prefixSum[start - 1] - negamax(prefixSum, i + 1, Math.max(m, (i - start + 1)), F));
        }
        F[start][m] = max;
        return max;
    }
}
