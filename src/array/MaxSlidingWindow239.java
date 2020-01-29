package array;

import sun.awt.image.ImageWatched;

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
        return maxSlidingWindowByStack(nums, k);
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

    private int[] maxSlidingWindowByStack(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        List<Integer> result = new LinkedList<>();
        Deque<Integer> pushDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            pushDeque.push(nums[i]);
            if (maxDeque.isEmpty()) {
                maxDeque.push(nums[i]);
            } else {
                int max = maxDeque.peek();
                if (max < nums[i]){
                    maxDeque.push(nums[i]);
                }
            }
        }
        result.add(maxDeque.peek());
        for (int j = k; j < nums.length; j++) {
            int val = pushDeque.pollLast();
            int max = maxDeque.getLast();
            if(val == max){
                maxDeque.pollLast();
            }
            pushDeque.push(nums[j]);
            max = maxDeque.getLast();
            if(nums[j] >= max){
                maxDeque.push(nums[j]);
            }
            result.add(maxDeque.getLast());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
