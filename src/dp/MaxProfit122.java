package dp;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class MaxProfit122 {
    /**
     * 这个问题将最大化算法问题转化为找到所有上升子序列之后将所有的和
     * 加起来就是最大利润，这个题目用暴力的方式只能使用枚举的方式。
     * 为什么每一次股票价格上涨的时候，我们在拐点就需要把股票卖掉呢？
     * 假入我们有四天，i,j,m,n，如果我们有关系prices[i] < prices[j] > prices[m] < prices[n]
     * <p>
     * 那么在拐点出交易时prices[j] - prices[i] + prices[n] - prices[m]
     * prices[j] + prices[n] - (prices[i] +  prices[m])，如果我们再加一个条件呢？prices[n] > prices[j]
     * 我们是不是交易一次能够获得的收益更大呢？我们假设prices[j] = prices[m] + gap;
     * 那么交易两次的数据为price[j] + prices[n] - prices[i] - prices[m] = prices[n] + gap.
     * 而交易一次能够获的的利润为prices[n] - prices[i]。很明显交易两次比交易一次能够获取到更多的利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int i = 0, len = prices.length, res = 0;
        while (i < len) {
            int k = i + 1;
            while (k < len && prices[k] >= prices[k - 1]) {
                k++;
            }
            res += (prices[k - 1] - prices[i]);
            i = k;
        }
        return res;
    }
}
