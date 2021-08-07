package dp;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2020/12/25
 */
public class StoneGameVII1690 {
    public int stoneGameVII(int[] stones) {
        int len = stones.length;

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return minMax(stones, 0, len - 1, Arrays.stream(stones).sum(), dp);
    }

    /**
     * stones[5,3,1,4,2]
     * 对于max-min方法，playerA是在已知playerB最优决策下做出自己的最优决策。既然是这样，因为playerA每次只能从
     * 石堆的两端取石头，所以只有两个策略。那么如果我们假定dp[][]二维数组其中dp[left][right]表示在石堆范围为left和right
     * 的情况下，playerA或者playerB能够做的最优决策。假如我们的stones数组的长度为stones.length = len。
     * 第一个回合，playerA是先手，如果取左边的石子, 则能够获得分数为
     * stones[1]+..+stoens[len - 1]这是这一步能够获得分数，但是其在做这个决策的时候是是根据下一步playerB所有决策来做出自己的决策。
     * 那么playerB的最优就是dp
     * 如果取右边的石子，则能够获得的分数为
     * stones[0]+..+stones[len - 2]这是这一步能够获得分数，playerB能够取得的最优决策是dp[0][len-2].
     * 其实我们这里很难理解这中计算方式，就是我们假定dp[i][j]是能够取得的最大的分数。
     *
     * @param stones
     * @param left
     * @param right
     * @return
     */
    private int minMax(int[] stones, int left, int right, int total, int[][] dp) {
        if (left >= right) {
            return 0;
        }
        if (dp[left][right] != Integer.MAX_VALUE) {
            return dp[left][right];
        }
        dp[left][right] = Math.max(total - stones[left] - minMax(stones, left + 1, right, total - stones[left], dp),
                total - stones[right] - minMax(stones, left, right - 1, total - stones[right], dp));
        return dp[left][right];
    }
}
