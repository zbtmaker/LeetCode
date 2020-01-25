package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class maximumProduct628 {

    /**
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        return maximumProductByBruteForce(nums);
    }

    /**
     * 这种方式使用的时间复杂度为O(N^3),空间复杂度为O(1)
     *
     * @param nums
     * @return
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

    private int maximumProductByDynamicProgramming(int[] nums) {

        return 0;
    }
}
