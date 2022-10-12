package dp;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/10/10
 */
public class MaxProfit188 {
    /**
     * 这个交易K次，那么我们一定是在[0, prices.length - 1]我们只能在
     * [0,i] 找到第一个最大值， 然后在[i + 1, prices.length - 1]范围内找到剩余的n - 1的位置。
     * 但是也有一个问题就是我们前面的[0,i]这个区间也可能不交易，如果在[0, i]。这种思路不行X
     * <p>
     * 我们用status--目前是持有状态还是卖出状态，index表明是第几天，
     *
     * @param k      交易次数
     * @param prices 价格
     * @return 最大收益
     */
    public int maxProfit(int k, int[] prices) {
        return memo(k, prices);
    }

    private int memo(int k, int[] prices) {
        int len = prices.length;
        int[][][] memo = new int[2][len + 1][k + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= len; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(k, prices, 0, 0, memo);
    }

    /**
     * 状态，买入、卖出。如果当前状态是
     * 买入 --> 保持不动（不做交易）、卖出
     * 卖出 --> 保持不动（不做交易）、买入
     *
     * @param k
     * @param prices
     * @param index
     * @param status
     * @return
     */
    private int dfs(int k, int[] prices, int index, int status, int[][][] memo) {
        if (index == prices.length || k == 0) {
            return 0;
        }

        int max = memo[status][index][k];
        if (max != -1) {
            return max;
        }
        /*if (status == 1) {
            max = Math.max(dfs(k, prices, index + 1, status, memo), dfs(k - 1, prices, index + 1, 0, memo) + prices[index]);
        } else {
            max = Math.max(dfs(k, prices, index + 1, status, memo), dfs(k, prices, index + 1, 1, memo) - prices[index]);
        }*/

        int keep = dfs(k, prices, index + 1, status, memo);
        int buy = 0, sale = 0;
        if (status == 1) {
            sale = dfs(k - 1, prices, index + 1, 0, memo) + prices[index];
        } else {
            buy = dfs(k, prices, index + 1, 1, memo) - prices[index];
        }
        max = Math.max(Math.max(sale, buy), keep);
        memo[status][index][k] = max;
        return max;
    }

    private int bottomUp(int k, int[] prices) {

        int len = prices.length;
        int[][][] memo = new int[2][len + 1][k + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= len; j++) {
                for (int m = 0; m <= k; m++) {
                    memo[i][j][m] = m == 0 ? 0 : -1;
                }
                Arrays.fill(memo[i][j], -1);
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= len; j++) {
                for (int m = k; m >= 1; m--) {

                }
            }
        }
        return 0;
    }
}
