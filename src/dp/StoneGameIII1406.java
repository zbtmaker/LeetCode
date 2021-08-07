package dp;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2020/12/26
 */
public class StoneGameIII1406 {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int result = minMax(stoneValue, 0, dp);
        if (result > 0) {
            return "Alice";
        } else if (result == 0) {
            return "Tie";
        } else {
            return "Bob";
        }
    }

    private int minMax(int[] stoneValue, int start, int[] dp) {
        int len = stoneValue.length;
        if (start >= len) {
            return 0;
        }
        if (dp[start] != Integer.MAX_VALUE) {
            return dp[start];
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < start + 3 && i < len; i++) {
            sum += stoneValue[i];
            max = Math.max(max, sum - minMax(stoneValue, i + 1, dp));
        }
        dp[start] = max;
        return dp[start];
    }
}
