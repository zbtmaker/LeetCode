package dp;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2021/02/22
 */
public class MaximumScore1770 {

    public int maximumScore(int[] nums, int[] multipliers) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        return recur(nums, 0, len - 1, multipliers, dp);
    }

    /**
     * 从这里可以看出recur(l,r) = max(recur(l+1, r) + nums[l] * multipliers[len - 1 - r + l],
     * recur(l,r - 1) +nums[r] * multipliers[len - 1 - r + l])
     * 我们要求的是recur(0,len - 1) = max(recur(1, len - 1) + nums[0] * multipliers[0],
     * recur(0,len - 2) + nums[len - 1] * multipliers[0])
     * 这里是时间复杂度超时了
     *
     * @param nums
     * @param l
     * @param r
     * @param multipliers
     * @param dp
     * @return
     */
    private int recur(int[] nums, int l, int r, int[] multipliers, int[][] dp) {
        if (l > r || nums.length - 1 - r + l >= multipliers.length) {
            return 0;
        }
        if (dp[l][r] != Integer.MIN_VALUE) {
            return dp[l][r];
        }
        int left = recur(nums, l + 1, r, multipliers, dp) + nums[l] * multipliers[nums.length - 1 - r + l];
        int right = recur(nums, l, r - 1, multipliers, dp) + nums[r] * multipliers[nums.length - 1 - r + l];
        dp[l][r] = Math.max(left, right);
        return dp[l][r];
    }
}
