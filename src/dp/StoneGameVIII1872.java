package dp;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/10/15
 */
public class StoneGameVIII1872 {

    public int stoneGameVIII(int[] stones) {
        int len = stones.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        int[] F = new int[len + 1];
        Arrays.fill(F, Integer.MIN_VALUE);
        F[len] = prefixSum[len];
        return dfs(prefixSum, 2, F);
    }

    /**
     * dfs(2) = Math.max(prefixSum[2] - dfs(3), prefixSum[3] - dfs(4),..., prefixSum[len - 1] - dfs(len));
     * dfs(3 ) = Math.max(prefixSum[3] - dfs(4), prefixSum[4] - dfs(5), ..., prefixSum[len - 1] - dfs(len));
     * ==> dfs(2) = Math.max(prefixSum[2] - dfs(3), dfs(3));
     */
    private int dfs(int[] prefixSum, int index, int[] F) {
        int len = prefixSum.length;
        if (index >= len) {
            return 0;
        }
        int max = F[index];
        if (max != Integer.MIN_VALUE) {
            return max;
        }
        max = Math.max(prefixSum[index] - dfs(prefixSum, index + 1, F), dfs(prefixSum, index + 1, F));
        F[index] = max;
        return max;
    }
}
