package array;

/**
 * Created by Administrator on 2019\1\20 0020.
 */
public class FindMaxAverage643 {

    /**
     * 这个题目转换一下，就是求解固定窗口大小内的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i = 0;
        for (; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return 1.0 * max / k;
    }
}
