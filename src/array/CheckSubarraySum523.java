package array;

/**
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 *
 * @author baitao zou
 * date 2020/02/22
 */
public class CheckSubarraySum523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        return checkSubarraySumByBruteForce(nums, k);
    }

    /**
     * 暴力算法: time complexity O(N^2), space complexity O(1)
     * 使用双指针的方法来解决问题。
     *
     * @param nums 数组
     * @param k    目标整数
     * @return
     */
    public boolean checkSubarraySumByBruteForce(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int sum = nums[i];
            if(sum > 0 && k == 0){
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if(sum == 0 && k == 0){
                    return true;
                }
                if(sum > 0 && k == 0){
                    break;
                }
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
