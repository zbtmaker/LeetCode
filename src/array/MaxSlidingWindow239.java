package array;

import java.util.ArrayList;

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
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = Math.min(k - 1, nums.length - 1); i < nums.length; i++) {
            int max = nums[i];
            for (int j = i; j > Math.max(-1, i - k); j--) {
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
