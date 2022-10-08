package dp;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/10/07
 */
public class CanPartitionKSubsets689 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int avg = sum / k;
        int[] bucket = new int[k];
        Arrays.sort(bucket);
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;

        }
        return dfs(nums, bucket, 0, avg);
    }

    private boolean dfs(int[] nums, int[] buckets, int index, int target) {
        if (index == nums.length) {
            return true;
        }
        for (int j = 0; j < buckets.length; j++) {

            if (j > 0 && buckets[j] == buckets[j - 1]) continue;

            if (buckets[j] + nums[index] > target) continue;
            buckets[j] += nums[index];
            boolean flag = dfs(nums, buckets, index + 1, target);
            buckets[j] -= nums[index];
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
