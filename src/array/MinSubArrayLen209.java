package array;

/**
 * LeetCode209:https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * @author baitao zou
 * date 2019/1/21
 */
public class MinSubArrayLen209 {

    /**
     * 采用滑动窗口的算法模板，具体可以参考LeetCode72
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int j = 0, i = 0;
        int sum = 0, min = Integer.MAX_VALUE;
        while (i < nums.length) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min((i - j + 1), min);
                sum -= nums[j];
                j++;
            }
            i++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
