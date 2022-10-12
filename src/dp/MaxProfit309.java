package dp;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/10/12
 */
public class MaxProfit309 {

    /**
     * 这个题目增加了一个冷冻期，相当于在之前的题目基础上增加了一个状态
     * 股票售出状态：此时进入了股票冷冻期一天
     * 股票买入状态：下一个状态应该是股票售出状态
     * 股票冷冻状态：此时可以有的操作就是变化未股票售出状态
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] F = new int[3][prices.length + 1];
        for (int[] aux : F) {
            Arrays.fill(aux, -1);
        }
        return dfs(prices, 0, 0, F);
    }

    private int dfs(int[] prices, int index, int status, int[][] F) {
        int max = F[status][index];
        if (max != -1) {
            return max;
        }
        if (index == prices.length) {
            return 0;
        }

        if (status == 0) {
            // 股票处于售出状态，此时可以继续保持当前状态，活着买入一支股票
            max = Math.max(dfs(prices, index + 1, status, F), dfs(prices, index + 1, 1, F) - prices[index]);
        } else if (status == 1) {
            // 股票处于买入状态，此时可以继续持有当前股票，或者售出股票进入到下一个冷冻期
            max = Math.max(dfs(prices, index + 1, status, F), dfs(prices, index + 1, 2, F) + prices[index]);
        } else {
            // 股票处于冷冻状态，冷冻期为一天，因此下一天的状态变更为
            max = dfs(prices, index + 1, 0, F);
        }
        F[status][index] = max;
        return max;
    }
}
