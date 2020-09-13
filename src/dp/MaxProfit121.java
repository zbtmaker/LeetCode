package dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 *
 * @author baitao zou
 * date 2020/09/13
 */
public class MaxProfit121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        return maxProfitByMemorizationII(prices);
    }

    /**
     * 因为这里我们这里只能买入卖出一次，且买入一定在卖出前，因此我们能够获得的最小收益为0
     * 同时我们当我们第i天买入股票，那么我们必须在i < j < prices.length的第j天将股票卖出
     * 那么我们的循环结构也就出来了。
     *
     * @param prices 股票价格
     * @return 收益
     */
    private int maxProfitByBruteForce(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (max < prices[j] - prices[i]) {
                    max = prices[j] - prices[i];
                }
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 之前我们考虑的是从第i天买入的时候，第j天卖出的时候我们能够获得的最大收益，
     * 但是我们换个角度来考虑，假如我们在第j天要卖出股票，那么，我们在前面那一天买入
     * 收益才是最大的。因此我们在前面BruteForce的基础上用一个一维数组来存储前j-1天
     * 最小的买入价格。
     *
     * @param prices 股票价格
     * @return 收益
     */
    private int maxProfitByMemorization(int[] prices) {
        int max = 0, len = prices.length;
        int[] minPrices = new int[len];
        minPrices[0] = prices[0];
        for (int i = 1; i < len; i++) {
            minPrices[i] = Math.min(minPrices[i - 1], prices[i]);
        }
        for (int i = 1; i < len; i++) {
            max = Math.max(prices[i] - minPrices[i - 1], max);
        }
        return max;
    }

    /**
     * 这个方法和上面的方法所不同的地方就在于，当我们要考虑第j天卖出的时候，我们只需要0-j-1天
     * 的最小值就可以了，所以不需要一个辅助空间将前面所有的最小值都存储起来。这样我们用一个minPrice
     * 变量来存储。
     *
     * @param prices 股票价格
     * @return 收益
     */
    private int maxProfitByMemorizationII(int[] prices) {
        int max = 0, len = prices.length, minPrices = prices[0];

        for (int i = 1; i < len; i++) {
            max = Math.max(prices[i] - minPrices, max);
            minPrices = Math.min(minPrices, prices[i]);
        }
        return max;
    }
}
