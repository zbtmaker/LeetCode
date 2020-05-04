package greedy;

/**
 * @author baitao zou
 * date 2020/05/04
 */
public class WiggleMaxLength376 {
    public int wiggleMaxLength(int[] nums) {
        return wiggleMaxLengthByDP(nums);
    }

    /**
     * 采用Memorization实现，为什么程序逻辑是对的，需要证明程序的不变式。
     * time comlexity O(N^2),space complexity O(N)
     *
     * @param nums
     * @return
     */
    private int wiggleMaxLengthI(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) {
            return len;
        }
        int[] flag = new int[len];
        int[] dp = new int[len];
        flag[0] = 0;
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int curFlag = 0;
            int curMax = 1;
            for (int j = i - 1; j >= 0; j--) {
                int tmpFlag = nums[i] - nums[j];
                int tmpMax = 0;
                if (flag[j] == 0 && tmpFlag != 0) {
                    tmpMax = 2;
                } else if (flag[j] != 0 && tmpFlag * flag[j] < 0) {
                    tmpMax = dp[j] + 1;
                }
                if (tmpMax > curMax) {
                    curMax = tmpMax;
                    curFlag = tmpFlag;
                }
            }
            dp[i] = curMax;
            flag[i] = curFlag;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 我们这里采用两个数组来记录数组升序和降序之间的关系，up数组表示升序，down便是降序
     * 如果nums[i] > nums[i-1]，那么这个时候我们以i结尾的是升序方式，那么肯定就要找到
     * i之前最后为降序的最大子数组，因此，up[i] = down[i-1] + 1;
     * 如果nums[i] < nums[i-1]，那么这个时候我们以i结尾的是降序方式，那么我们就要找到
     * 以i-1结尾的升序的最大子数组，因此down[i] = up[i-1] + 1;
     * 如果nums[i-1] == nums[i]，那么这个时候最后即飞升序也非降序。因此以i结尾的数组的摆动序列长度
     * 和i-1的长度是一致的。
     * 这里其实最主要的就是我们用down和up两个数组来记录了以i结尾升序和降序的摆动序列，这样我们就不需要
     * 再计算之前状态了。这个题目和MinSwap801有些相似
     *
     * @param nums
     * @return
     */
    private int wiggleMaxLengthByDP(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) {
            return len;
        }
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(down[len - 1], up[len - 1]);
    }

    /**
     * 空间优化有的动态规划
     *
     * @param nums
     * @return
     */
    private int wiggleMaxLengthByDPOpt(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) {
            return len;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }


}
