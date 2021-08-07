package dp;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/08/08
 */
public class CanPartitionKSubsets698 {
    /**
     * 之前是将一个数组划分成两个相等的数组，现在是划分成多个数组，其实这个题目也是在求两数之和，之前的两数之和采用time complexityO(N), space complexity O(N)
     * 这里我们通过自顶向下递归的方式实现。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }
        int avg = sum / k;

        return false;
    }
}
