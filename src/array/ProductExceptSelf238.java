package array;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * tags: arr、memorization
 *
 * @author baitao zou
 * date 2020/03/22
 */
public class ProductExceptSelf238 {
    /**
     * 对于任意一个索引i in {0, len-1},我们需要计算左边的乘积和右边的乘积。
     * 这样就可以用空间换时间。如果不采用两个数组的方案，那么对于每一个数都需要计算
     * 左边和右边的乘积，因此time complexity为O(N^2).
     * 那么我们就可以用两个数组left和right数组来记录每一个索引的左边乘积和右边乘积。
     * 这样我们的time complexity变为O(3N) = O(N).
     *
     * @param nums
     * @return 数组乘积
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] result = new int[len];
        int[] left = new int[len];
        left[0] = 1;

        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = len - 2; j > -1; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < len; k++) {
            result[k] = left[k] * right[k];
        }
        return result;
    }
}
