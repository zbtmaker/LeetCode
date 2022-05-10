package array;

/**
 * Created by Administrator on 2019\2\27 0027.
 */
public class ThreeSumClosest16 {
    /**
     * 算法时间复杂度O(N^3)，空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosestI(int[] nums, int target) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmpSum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(tmpSum - target) < minSum) {
                        minSum = Math.abs(tmpSum - target);
                        sum = tmpSum;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 改善时间复杂度O(N^2)，牺牲的空间复杂度O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosestII(int[] nums, int target) {
        return 0;
    }
}
