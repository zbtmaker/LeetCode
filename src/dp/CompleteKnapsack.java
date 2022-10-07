package dp;

import java.util.Arrays;

/**
 * 完全背包问题：有n种物品和一个容量为W的背包，每种物品有重量w和价值两种属性，
 * 要求选若干物品放入背包使背包中物品的总价值最大，且背包的重量不超过背包的容量。
 * <p>
 * 完全背包问题，因为每种物品的数量不限，因此每一层都是一个完全的二叉树，因此这里在
 * 递归的时候只有背包的剩余重量这个变化因素，其他都是不变的。
 *
 * @author zoubaitao
 * date 2022/10/03
 */
public class CompleteKnapsack {

    public int compoteKnapsack(int W, int[] w, int[] v) {
        return dfsMemorize(W, w, v);
    }

    private int dfs(int W, int[] w, int[] v) {
        int max = 0;
        for (int i = 0; i < w.length; i++) {
            if (W >= w[i]) {
                int cur = dfs(W - w[i], w, v) + v[i];
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    private int dfsMemorize(int W, int[] w, int[] v) {
        int[] F = new int[W + 1];
        Arrays.fill(F, -1);
        F[0] = 0;
        return dfsMemorize(W, w, v, F);

    }

    private int dfsMemorize(int W, int[] w, int[] v, int[] F) {
        if (F[W] != -1) {
            return F[W];
        }
        int max = 0;
        for (int i = 0; i < w.length; i++) {
            if (W >= w[i]) {
                int cur = dfsMemorize(W - w[i], w, v, F) + v[i];
                max = Math.max(cur, max);
            }
        }
        F[W] = max;
        return max;
    }

    private long bottomUp(int W, int[] w, int[] v) {
        long[] F = new long[W + 1];
        for (int i = 1; i <= W; i++) {
            long max = 0;
            for (int j = 0; j < w.length; j++) {
                if (i >= w[j]) {
                    max = Math.max(max, F[i - w[j]] + v[j]);
                }
            }
            F[i] = max;
        }
        return F[W];
    }
}
