package dp;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2020/12/26
 */
public class StoneGameII1140 {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int result = negamax(piles, 0, 1, dp);
        return (result + Arrays.stream(piles).sum()) >> 1;
    }

    private int negamax(int[] piles, int start, int m, int[] dp) {
        int len = piles.length;
        if (start >= len) {
            return 0;
        }
        if (dp[start] != Integer.MAX_VALUE) {
            return dp[start];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int l = start + 2 * m;
        for (int i = start; i < l && i < len; i++) {
            sum += piles[i];
            max = Math.max(max, sum - negamax(piles, i + 1, Math.max(m, (i - start + 1)), dp));
        }
        dp[start] = max;
        return dp[start];
    }
}
