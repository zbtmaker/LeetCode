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
        int[][] F = new int[2][prices.length + 1];
        for (int[] aux : F) {
            Arrays.fill(aux, Integer.MIN_VALUE);
        }
        return dfs(prices, 0, 0, 1, F);
    }

    private int dfs(int[] prices, int index, int status, int frozen, int[][] F) {
        if (index >= prices.length) {
            return 0;
        }
        int max = F[status][index];
        if (max != Integer.MIN_VALUE) {
            return max;
        }
        int keep = dfs(prices, index + 1, status, frozen, F);
        int buy = 0, sale = 0;
        if (status == 1) {
            sale = dfs(prices, index + frozen + 1, 0, frozen, F) + prices[index];
        } else {
            buy = dfs(prices, index + 1, 1, frozen, F) - prices[index];
        }
        max = Math.max(Math.max(sale, buy), keep);
        F[status][index] = max;
        return max;
    }
}
