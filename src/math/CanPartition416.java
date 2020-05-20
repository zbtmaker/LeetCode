package math;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 *
 * @author baitao zou
 * date 2020/04/12
 */
public class CanPartition416 {

    /**
     * 这个问题我们其实可以划转换一下，如果一个集合能够被划分成两个和相等的子集，那么这个集合所有元素
     * 之和必须是一个整数。
     * 一、实现一个二维的动态规划
     * 第一步：对集合中所有元素求和得到集合总合sum,然后判断一个数是否是奇数还是偶数，千万
     * 不要采用取余的方式，非常耗时间（为什么取余耗时间，有待研究）,那么我们可以采用&操作，一个奇数和1执行
     * &操作最终值为1，一个偶数与1执行&操作最终值为0。
     * 第二步：我们将问题转换成在集合nums中需要找到一个子数组，这个子数组的所有元素之和等于sum/2。我们第一件事情
     * 想到的就是对nums集合进行穷举，但是一穷举，我们就会发现这个问题和背包问题特别像，那么我们如何来做这个题目呢。
     * 1、我们定义我们的目标方程dp[i][j]表示前i个元素能够凑成j。前i个元素可以凑成j,就像背包问题一样，将问题分成
     * 两种情况，第一种是dp[i][j] = dp[i-1][j],表示由前面i-1个元素就可以凑成目标j,
     * 2、第二种情况是需要第i个元素才能凑成j,那么dp[i][j] = dp[i][j-nums[i]];
     * 所以综和上面两种情况，前面i个元素能够凑成j要么是dp[i-1][j] = true ，要们是dp[i][j-nums[i] = true。
     * 这样得到我们的递推关系是dp[i][j] = dp[i-1][j] || dp[i][j-nums[i]].
     * 3、得到递推关系式之后，我们还需要做的就是找出初始值，就像数学归纳法一样，由初始值推后面所有的递推关系式
     * 二、实现一个一维的动态规划（待优化）
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        return canPartitionByDP(nums);
    }

    private boolean canPartitionByDP(int[] nums) {
        return canPartitionByTopDownDynamicProgramming(nums);
    }

    private boolean canPartitionByTopDownDynamicProgramming(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = sum(nums);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        int[][] F = new int[len + 1][target + 1];
        F[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                F[i][j] = -1;
            }
        }
        return recurCanPartitionByTopDownDynamicProgramming(nums, target, len, F) == 1;
    }

    private int recurCanPartitionByTopDownDynamicProgramming(int[] nums, int sum, int n, int[][] F) {
        if (sum == 0 && n == 0) {
            return 1;
        }
        if (n <= 0 || sum <= 0) {
            return 0;
        }
        if (F[n][sum] >= 0) {
            return F[n][sum];
        }
        if (sum < nums[n - 1]) {
            F[n][sum] = F[n - 1][sum];
            return F[n][sum];
        }
        F[n - 1][sum] = recurCanPartitionByTopDownDynamicProgramming(nums, sum, n - 1, F);
        F[n - 1][sum - nums[n - 1]] = recurCanPartitionByTopDownDynamicProgramming(nums, sum - nums[n - 1], n - 1, F);
        return F[n][sum] = F[n - 1][sum] | F[n - 1][sum - nums[n - 1]];
    }

    private boolean canPartitionByBottomUpDynamicProgramming(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = sum(nums);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][target + 1];
        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
        dp[0][0] = true;
        for (int i = 1; i <= target; i++) {

            dp[0][i] = false;
        }
        for (int j = 1; j <= len; j++) {
            dp[j][0] = false;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len][target];
    }

    /**
     * 回溯算法，对于回溯算法
     *
     * @param nums
     * @return
     */
    private boolean canPartitionByBacktracking(int[] nums) {
        return canPartitionByTopDownBacktracking(nums);
    }

    /**
     * 自顶向下回溯
     *
     * @param nums
     * @return
     */
    private boolean canPartitionByTopDownBacktracking(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = sum(nums);
        if ((sum & 1) == 1) {
            return false;
        }
        return recurCanPartitionByTopDownBacktracking(nums, sum >> 1, nums.length);
    }


    private boolean recurCanPartitionByTopDownBacktracking(int[] nums, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || n == 0) {
            return false;
        }

        return recurCanPartitionByTopDownBacktracking(nums, sum, n - 1) || recurCanPartitionByTopDownBacktracking(nums, sum - nums[n - 1], n - 1);
    }

    /**
     * 自底向上回溯
     *
     * @param nums
     * @return
     */
    private boolean canPartitionByBottomUpBacktracking(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = sum(nums);
        if ((sum & 1) == 1) {
            return false;
        }
        return recurCanPartitionByTopDownBacktracking(nums, sum >> 1, nums.length);
    }

    /**
     * 递归解决该问题，递归的方式解决这个问题，我们从0开始计算，如果我们的target == 0，那么表示数组总存在一个有效的子数组使得
     *
     * @param nums
     * @param index
     * @param target
     * @return
     */
    private boolean recurCanPartitionByBottomUpBacktracking(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            target -= nums[i];
            if (recurCanPartitionByBottomUpBacktracking(nums, i + 1, target)) {
                return true;
            }
            target += nums[i];
        }
        return false;
    }

    /**
     * 对数组求和
     *
     * @param nums
     * @return
     */
    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
