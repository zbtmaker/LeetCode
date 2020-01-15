package dp;

/**
 * Created by Administrator on 2019\1\28 0028.
 */
public class MaxProduct152 {

    public int maxProduct(int[] nums) {
        /*return maxProductByBruteForce(nums);*/
        return maxProductByDynamicProgramming(nums);
    }

    /**
     * 首先我用暴力的的方式解决这个问题，时间复杂度为O(N^3)的，空间复杂度为O(1),那下一步是不是就应该来优化这个算法了
     *
     * @param nums 数组
     * @return 最大值
     */
    private int maxProductByBruteForce(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int mul = nums[j];
                for (int k = j + 1; k <= i; k++) {
                    mul *= nums[k];
                }
                max = Math.max(max, mul);
            }
        }
        return max;
    }

    /**
     * 上面我们使用的暴力方式会涉及到一些重复计算，因此我们可以优化一下。我们用一个数组
     * aux来记录前面i个数的乘积，其中aux[i]=nums[0]*nums[1]*nums[i],如此以来就有
     * 下面的关系：aux[i] = aux[i-1] * nums[i]。此时的采用一个数组记录前面子数组的
     * 乘积，防止第三层循环。将时间复杂度变为O(N^2)，但是空间复杂度变为O(N)。但是这种方式
     * 还是会超时。
     *
     * @param nums
     * @return 最大乘积子数组
     */
    private int maxProductByDynamicProgramming(int[] nums) {
        int[] aux = new int[nums.length + 1];
        aux[0] = 1;
        int max = nums[0];
        int zeroIndex = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            max = Math.max(max, nums[i - 1]);
            if (nums[i - 1] == 0) {
                zeroIndex =  i;
                aux[i] = 1;
                continue;
            }
            for (int j = zeroIndex; j < i; j++) {
                int mul = nums[i - 1] * aux[i - 1] / aux[j];
                if (j == zeroIndex) {
                    aux[i] = mul;
                }
                max = Math.max(max, mul);
            }
        }
        return max;
    }
}
