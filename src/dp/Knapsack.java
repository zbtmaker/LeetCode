package dp;

/**
 * @author baitao zou
 * date 2020/04/22
 */
public class Knapsack {


    public int knapsack(int L, int[] A, int[] C) {
        return knapsackByBottomUpMemorization(L, A, C);
    }

    private int knapsackByBacktracking(int L, int[] A, int[] C) {
        /*int[] maxValue = new int[]{0, Integer.MIN_VALUE};
        knapsackBottomUpRecursive(amount, A, C, 0, maxValue);
        return maxValue[1];*/
        /*return knapsackTopDownRecursive(L, A, C, A.length - 1);*/
        int[][] F = new int[A.length + 1][L + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= L; j++) {
                F[i][j] = -1;
            }
        }
        return knapsackByTopDownMemorization(L, A, C, A.length, F);
    }

    /**
     * 为什么要写一个递归版本，主要是这么多讲解knapsack problem的都是直接给出公式，希望能够画出一个二叉树，这样我们就能把所有的情况都列举出来从而看看这个
     * 递归版本中到底有哪些是重复计算了的。我们就能把之前计算的结果存储起来，这样我们就能更好的理解Knapsack的dynamic programming版本。否则这个knapsack
     * 问题我永远也学不会。
     *
     * @param L        资源
     * @param A        物品成本数组
     * @param C        物品利润
     * @param maxValue 当前利润和最大利润
     */
    private void knapsackBottomUpRecursive(int L, int[] A, int[] C, int n, int[] maxValue) {
        if (L >= 0) {
            maxValue[1] = Math.max(maxValue[0], maxValue[1]);
        } else {
            return;
        }
        for (int i = n; i < A.length; i++) {
            L -= A[i];
            maxValue[0] += C[i];
            knapsackBottomUpRecursive(L, A, C, i + 1, maxValue);
            L -= A[i];
            maxValue[0] -= C[i];
        }
    }

    /**
     * 其实
     *
     * @param L 资源
     * @param A 物品成本数组
     * @param C 物品利润
     * @param n 第n个物品
     * @return 最大利润
     */
    private int knapsackTopDownRecursive(int L, int[] A, int[] C, int n) {
        if (n < 0) {
            return 0;
        }
        if (L < A[n]) {
            return knapsackTopDownRecursive(L, A, C, n - 1);
        }
        return Math.max(knapsackTopDownRecursive(L, A, C, n - 1), knapsackTopDownRecursive(L - A[n], A, C, n - 1) + C[n]);
    }

    private int knapsackByTopDownMemorization(int L, int[] A, int[] C, int n, int[][] F) {
        if (n == 0) {
            return 0;
        }
        if (F[n][L] >= 0) {
            return F[n][L];
        }
        if (L < A[n - 1]) {
            F[n][L] = knapsackByTopDownMemorization(L, A, C, n - 1, F);

        } else {
            F[n][L] = Math.max(knapsackByTopDownMemorization(L, A, C, n - 1, F), knapsackByTopDownMemorization(L - A[n - 1], A, C, n - 1, F) + C[n - 1]);
        }
        return F[n][L];
    }

    /**
     * 自底向上解决背包问题
     *
     * @param L 资源
     * @param A 物品成本数组
     * @param C 物品利润
     * @return 最大利润
     */
    private int knapsackByBottomUpMemorization(int L, int[] A, int[] C) {
        int[][] F = new int[A.length + 1][L + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= L; j++) {
                if (j < A[i-1]) {
                    F[i][j] = F[i - 1][j];
                } else {
                    F[i][j] = Math.max(F[i - 1][j], F[i - 1][j - A[i - 1]] + C[i - 1]);
                }
            }
        }
        return F[A.length][L];
    }
}
