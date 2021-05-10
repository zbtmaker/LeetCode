package array;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2021/05/10
 */
public class MaxSumMinProduct1856 {
    public int maxSumMinProduct(int[] nums) {
        return maxSumMinProductBruteForce(nums);
    }

    private int maxSumMinProductBruteForce(int[] nums) {
        int len = nums.length;
        long[] leftSum = new long[len];
        leftSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int j = i - 1;
            while (j > -1 && nums[j] >= nums[i]) {
                j--;
            }
            int k = i + 1;
            while (k < len && nums[k] >= nums[i]) {
                k++;
            }
            max = Math.max(max, nums[i] * (leftSum[k - 1] - leftSum[j + 1] + nums[j + 1]));
        }
        return (int) (max % ((long) Math.pow(10, 9) + 7));
    }
}
