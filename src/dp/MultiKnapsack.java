package dp;

/**
 * @author zoubaitao
 * date 2022/10/03
 */
public class MultiKnapsack {

    public int multiKnapsack(int W, int[] w, int[] v, int[] nums) {
        return dfsMemorize(W, w, v, nums);
    }

    private int dfs(int W, int[] w, int[] v, int[] nums) {
        return dfs(W, w, v, nums, 0);
    }

    private int dfs(int W, int[] w, int[] v, int[] nums, int k) {
        if (W == 0) {
            return 0;
        }
        int max = 0;
        for (int i = k; i < w.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (W >= j * w[i]) {
                    max = Math.max(max, dfs(W - j * w[i], w, v, nums, i + 1) + j * v[i]);
                }
            }
        }
        return max;
    }

    private int dfsMemorize(int W, int[] w, int[] v, int[] nums) {
        int[][] F = new int[W + 1][w.length + 1];
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= w.length; j++) {
                F[i][j] = -1;
            }
        }
        return dfsMemorize(W, w, v, nums, 1, F);
    }

    private int dfsMemorize(int W, int[] w, int[] v, int[] nums, int k, int[][] F) {
        if (W == 0 || k > w.length) {
            return 0;
        }
        if (F[W][k] != -1) {
            return F[W][k];
        }
        int max = 0;
        for (int i = k; i <= w.length; i++) {
            for (int j = 1; j <= nums[i - 1]; j++) {
                if (W >= j * w[i - 1]) {
                    max = Math.max(max, dfsMemorize(W - j * w[i - 1], w, v, nums, i + 1, F) + j * v[i - 1]);
                }
            }
        }
        F[W][k] = max;
        return max;
    }
}
