package dp;

/**
 * @author Baitao Zou
 * date 2021/01/09
 */
public class MaxProfit123 {

    /**
     * 这里我们可以看到，我们第k天 0 ≤ k ≤ prices.length - 1，有以下四种状态
     * hold1：第一次买入这支股票
     * sold1：第一次卖出这支股票
     * hold2：第二次买入这支股票
     * sold2：第二次卖出这支股票
     * 那么我们分析以下；
     * 如果是hold1[k]，可能是hold1[k-1]，表示第k-1天买入的；或者是第k天买入的，0 - p。
     * 如果是sold1[k]，可能是sold1[k-1]，表示第k-1天卖出的；或者是第k天卖出的，hold1[k-1] + p。
     * 如果是hold2[k]，可能是hold2[k-1]，表示第k-1天第二次买入的；或者第k天买入的，sold1[k-1] - p。
     * 如果是sold2[k]，可能是sold2[k-1]，表示第k-1天第二次卖出的；或者第k天卖出的，hold2[k] + p。
     *
     * @param prices 股票价格
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, sold1 = 0, hold2 = Integer.MIN_VALUE, sold2 = 0;
        for (int p : prices) {
            int tmpHold1 = hold1, tmpSold1 = sold1, tmpHold2 = hold2, tmpSold2 = sold2;
            hold1 = Math.max(0 - p, tmpHold1);
            sold1 = Math.max(p + tmpHold1, tmpSold1);
            hold2 = Math.max(tmpSold1 - p, tmpHold2);
            sold2 = Math.max(p + tmpHold2, tmpSold2);
        }
        return Math.max(sold1, sold2);
    }
}
