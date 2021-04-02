package array;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/01/27
 */
public class MaxSlidingWindow239 {

    /**
     * @param nums 数组
     * @param k    窗口大小
     * @return 最大值数组
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
//        return maxSlidingWindowByBruteForce(nums, k);
        return maxSlidingWindowByDequeue(nums, k);
    }

    /**
     * 通过暴力破解的方式得到解决方案
     *
     * @param nums 数组
     * @param k    窗口大小
     * @return 窗口最大值数组
     */
    private int[] maxSlidingWindowByBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        List<Integer> result = new LinkedList<>();
        for (int i = Math.min(k - 1, nums.length - 1); i < nums.length; i++) {
            int max = nums[i];
            for (int j = i; j > Math.max(-1, i - k); j--) {
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] maxSlidingWindowByDequeue(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        WindowQueue windowQueue = new WindowQueue();
        for (int i = 0; i < len; i++) {
            windowQueue.push(nums[i]);
            if (i + 1 - k >= 0) {
                int max = windowQueue.max();
                result[i + 1 - k] = max;
                if (nums[i + 1 - k] == max) {
                    windowQueue.poll();
                }
            }
        }
        return result;
    }

}
