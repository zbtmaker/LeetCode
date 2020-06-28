package array;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2019/1/18
 */
public class MaximumProduct628 {

    /**
     * @param nums 目标数组
     * @return 最大乘积
     */
    public int maximumProduct(int[] nums) {
        return maximumProductBySort(nums);
    }

    /**
     * 这种方式使用的时间复杂度为O(N^3),空间复杂度为O(1)
     *
     * @param nums 目标数组
     * @return 最大乘积
     */
    private int maximumProductByBruteForce(int[] nums) {
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = nums[i] * nums[j] * nums[k];
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    /**
     * 采用排序的方式，时间复杂度为O(NlogN),空间复杂度为O(1)
     *
     * @param nums 数组
     * @return 三数最大乘积
     */
    private int maximumProductBySort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }

    /**
     * 采用线性扫描的方式解决问题
     *
     * @param nums 数组
     * @return 三数最大乘积
     */
    private int maximumProductByScan(int[] nums) {

        return 0;
    }
}
