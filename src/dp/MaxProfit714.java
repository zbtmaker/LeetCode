package dp;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/10/11
 */
public class MaxProfit714 {

    /**
     * 这个题目理论上应该是MaxProfit122题目的一个扩展，同样是可以无限次交易，但是每次交易都需要一笔交易费用，
     * 还是一样的，我们每一次要找到一个最长上升子序列，然后进行交易，但是如果这一次交易产生的利润还没有交易费用
     * 高，那么就不会产生交易，因为还会产生负利润。但是真的每一次
     * 假入我们有四天，i,j,m,n，如果我们有关系prices[i] < prices[j] > prices[m] < prices[n]
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] F = new int[3][prices.length + 1];
        for (int[] aux : F) {
            Arrays.fill(aux, -1);
        }
        return dfs(prices, fee, 0, 0, F);
    }

    private int dfs(int[] prices, int fee, int index, int status, int[][] F) {
        int max = F[status][index];
        if (max != -1) {
            return max;
        }
        if (index == prices.length) {
            return 0;
        }
        int keep = dfs(prices, fee, index + 1, status, F);
        int buy = 0, sale = 0;
        if (status == 1) {
            sale = dfs(prices, fee, index + 1, 0, F) + prices[index] - fee;
        } else {
            buy = dfs(prices, fee, index + 1, 1, F) - prices[index];
        }
        max = Math.max(keep, Math.max(buy, sale));
        F[status][index] = max;
        return max;
    }

}
