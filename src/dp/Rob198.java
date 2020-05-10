package dp;

/**
 * @author baitao zou
 * date 2020/05/10
 */
public class Rob198 {
    /**
     * 这个题目采用动态规划解决，自顶向下分析。还是一样，采用动态规划三步走。
     * 第一步：定义数据存储方式和含义，定义dp[i]表示长度为i的数组能够偷到的最大价值
     * 第二步：找到状态方程，当我们处在第i栋房子时我们能够取得的最大价值取决于什么，其实就是
     * 取决于我们dp[i-2]和dp[i-1]能够偷到的最大价值，如果dp[i-2]+nums[i-1]能够偷盗的最大
     * 价值的物品大于dp[i-1]的价值，那么我们肯定会偷第i栋房子的物品，否则，我们不会偷第i栋房子的
     * 物品因此我们就得到了我们的状态转移方程
     * dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1])
     * 第三步：当没有房子时，即：i=0，dp[i] = 0,当只有一栋房子时，小偷只有偷这栋房子才能取得最大值
     * 因此dp[1] = nums[0];
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        return robByOneDimension(nums);
    }

    private int robByOneDimension(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    private int robByConstant(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fir = 0;
        int sec = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int max = Math.max(sec, fir + nums[i - 1]);
            fir = sec;
            sec = max;
        }
        return sec;
    }
}
