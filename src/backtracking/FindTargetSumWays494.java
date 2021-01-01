package backtracking;

/**
 * @author Baitao Zou
 * date 2021/01/01
 */
public class FindTargetSumWays494 {
    private int count = 0;

    /**
     * @param nums 数组
     * @param S    目标和
     * @return 返回满足目标和的方式
     */
    public int findTargetSumWays(int[] nums, int S) {
        recur(nums, 0, 0, S);
        return this.count;
    }

    /**
     * 递归方式
     *
     * @param nums   数组
     * @param index  索引
     * @param sum    当前位置目标和
     * @param target 目标和
     */
    private void recur(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        sum += nums[index];
        recur(nums, index + 1, sum, target);
        sum -= 2 * nums[index];
        recur(nums, index + 1, sum, target);
    }
}
