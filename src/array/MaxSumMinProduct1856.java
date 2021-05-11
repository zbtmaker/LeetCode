package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Baitao Zou
 * date 2021/05/10
 */
public class MaxSumMinProduct1856 {
    public int maxSumMinProduct(int[] nums) {
        return maxSumMinProductMonotonicDequeue(nums);
    }

    private int maxSumMinProductBruteForce(int[] nums) {
        int len = nums.length;
        long[] preSum = new long[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
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
            max = Math.max(max, nums[i] * (preSum[k - 1] - preSum[j + 1] + nums[j + 1]));
        }
        return (int) (max % ((long) Math.pow(10, 9) + 7));
    }

    private int maxSumMinProductMonotonicDequeue(int[] nums) {
        int len = nums.length;
        long[] preSum = new long[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int[] leftAux = new int[len];
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] >= nums[i]) {
                queue.pollLast();
            }
            if (queue.isEmpty()) {
                leftAux[i] = 0;
            } else {
                leftAux[i] = queue.peekLast() + 1;
            }
            queue.addLast(i);
        }
        queue.clear();
        int[] rightAux = new int[len];
        for (int j = len - 1; j > -1; j--) {
            while (!queue.isEmpty() && nums[queue.peekLast()] >= nums[j]) {
                queue.pollLast();
            }
            if (queue.isEmpty()) {
                rightAux[j] = len - 1;
            } else {
                rightAux[j] = queue.peekLast() - 1;
            }
            queue.addLast(j);
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, (preSum[rightAux[i]] - preSum[leftAux[i]] + nums[leftAux[i]]) * nums[i]);
        }
        return (int) (max % ((long) Math.pow(10, 9) + 7));
    }
}
