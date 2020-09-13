package dp;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class MaxProfit122 {
    /**
     * 这个问题将最大化算法问题转化为找到所有上升子序列之后将所有的和
     * 加起来就是最大利润，这个题目用暴力的方式只能使用枚举的方式。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 0) {
            return 0;
        }
        int profit = 0, init = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] > prices[i]) {
                profit = profit + prices[i - 1] - init;
                init = prices[i];
            } else if (i == len - 1) {
                profit = profit + prices[i] - init;
            }
        }
        return profit;
    }
}
