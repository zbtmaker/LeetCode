package dp;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/10/05
 */
public class ProfitableSchemes879 {

    /**
     * 当n = 0, 且minProfit = 0时, 那么此时应该都是0，也就是F[0][minProfit][k] = 0。
     * 当n > 0, 且minProfit = 0时, k = 0, F[n][0][0] = 0, k > 0 时，此时需要递推公式
     *
     * @param n         公司人数
     * @param minProfit 公司最少需要盈利的数额
     * @param group     第kth任务需要的人数
     * @param profit    kth任务完成之后的利润
     * @return 总的方案数
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] F = new int[n + 1][minProfit + 1][group.length + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= minProfit; j++) {
                Arrays.fill(F[i][j], -1);
            }
        }
        return (int) dfs(n, minProfit, group, profit, 0, F);
    }

    public long dfs(int n, int minProfit, int[] group, int[] profit, int k, int[][][] F) {
        if (k == group.length) {
            return minProfit == 0 ? 1 : 0;
        }
        if (F[n][minProfit][k] != -1) {
            return F[n][minProfit][k];
        }
        int res = minProfit <= 0 ? 1 : 0;
        for (int i = k; i < group.length; i++) {
            if (n >= group[i]) {
                int nextProfit = Math.max(minProfit - profit[i], 0);
                res += dfs(n - group[i], nextProfit, group, profit, i + 1, F);
            }
        }
        F[n][minProfit][k] = res % ((10 ^ 9) + 7);
        return F[n][minProfit][k];
    }
}
