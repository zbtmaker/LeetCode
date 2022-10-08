package dp;

/**
 * @author zoubaitao
 * date 2022/10/07
 */
public class SplitArray410 {

    int len = 0;

    /**
     * 这里需要把数组nums分割成k个连续的子数组，然后找出不同的划分策略下的最大值最小（相当于我们要找出
     * 所有的划分方式，然后计算所有方式的最大值，然后找出所有最大值的最小）。如果我们枚举出所有的结果，那么
     * 我们每一步需要计算区间内的结果，比方说加入，我们第一步的区间为
     *
     * @param nums 数组
     * @param k    划分成k个子数组
     * @return 最大值最小
     */
    public int splitArray(int[] nums, int k) {
        len = nums.length;
        int[] prefixSum = new int[len + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        /*return dfs(k, 0, prefixSum);*/
        return dfsMemorize(k, prefixSum);
    }

    private int dfs(int k, int index, int[] prefixSum) {
        if (k == 1) {
            return prefixSum[len] - prefixSum[index];
        }
        int min = Integer.MAX_VALUE;
        for (int i = index; i < len - (k - 1); i++) {
            min = Math.min(min, Math.max(prefixSum[i + 1] - prefixSum[index], dfs(k - 1, i + 1, prefixSum)));
        }
        return min;
    }

    private int dfsMemorize(int k, int[] prefixSum) {
        int[][] F = new int[len + 1][k + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                F[i][j] = -1;
            }
        }
        return dfsMemorize(k, 0, prefixSum, F);
    }

    private int dfsMemorize(int k, int index, int[] prefixSum, int[][] F) {
        if (F[index][k] != -1) {
            return F[index][k];
        }
        if (k == 1) {
            return prefixSum[len] - prefixSum[index];
        }
        int min = Integer.MAX_VALUE;
        for (int i = index; i < len - (k - 1); i++) {
            min = Math.min(min, Math.max(prefixSum[i + 1] - prefixSum[index], dfsMemorize(k - 1, i + 1, prefixSum, F)));
        }
        F[index][k] = min;
        return min;
    }
}
