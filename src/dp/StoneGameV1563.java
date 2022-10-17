package dp;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/10/15
 */
public class StoneGameV1563 {

    public int stoneGameV(int[] stoneValue) {
        int len = stoneValue.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
        }
        int[][] F = new int[len + 1][len + 1];
        for (int[] f : F) {
            Arrays.fill(f, -1);
        }
        return dfs(prefixSum, 1, len, F);
    }

    private int dfs(int[] prefixSum, int left, int right, int[][] F) {
        if (left >= right) {
            return 0;
        }
        int max = F[left][right];
        if (max != -1) {
            return max;
        }
        for (int i = left; i < right; i++) {
            int sumLeft = prefixSum[i] - prefixSum[left - 1];
            int sumRight = prefixSum[right] - prefixSum[i];
            int res;
            if (sumLeft > sumRight) {
                res = sumRight + dfs(prefixSum, i + 1, right, F);
            } else if (sumLeft < sumRight) {
                res = sumLeft + dfs(prefixSum, left, i, F);
            } else {
                res = sumLeft + Math.max(dfs(prefixSum, left, i, F), dfs(prefixSum, i + 1, right, F));
            }
            max = Math.max(max, res);
        }
        return F[left][right] = max;
    }

}
