package array;

import java.util.ArrayDeque;

/**
 * @author Baitao Zou
 * date 2021/03/21
 */
public class ShortestSubarray862 {
    public int shortestSubarray(int[] A, int K) {
        return shortestSubArrayMonotonicQueue(A, K);
    }

    /**
     * 这个题目要用到前缀和，不是简简单单的单调队列，所以我们必须通过下面的shortestSubArrayBruteForce
     * 得到数组的前置和，然后根据前缀和去找到相应的规律才可以。
     *
     * @param arr
     * @param k
     * @return
     */
    private int shortestSubArrayMonotonicQueue(int[] arr, int k) {
        int len = arr.length;
        int[] count = new int[len + 1];
        for (int i = 0; i < len; i++) {
            count[i + 1] = count[i] + arr[i];
        }
        WindowQueue windowQueue = new WindowQueue();
        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= len; j++) {
            min = Math.min(min, windowQueue.push(j, k, count));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private class WindowQueue {
        private ArrayDeque<Integer> arrayDeque;

        public WindowQueue() {
            this.arrayDeque = new ArrayDeque<>();
        }

        public int push(int index, int target, int[] preSum) {
            int min = Integer.MAX_VALUE;
            while (!arrayDeque.isEmpty() && preSum[index] <= preSum[arrayDeque.peekLast()]) {
                arrayDeque.pollLast();
            }
            while (!arrayDeque.isEmpty() && preSum[index] >= preSum[arrayDeque.getFirst()] + target) {
                min = Math.min(min, index - arrayDeque.removeFirst());
            }
            arrayDeque.addLast(index);
            return min;
        }
    }

    /**
     * 暴力计算方式超出时间范围了
     *
     * @param arr
     * @param k
     * @return
     */
    private int shortestSubArrayBruteForce(int[] arr, int k) {
        int len = arr.length;
        int[] count = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            count[i] = count[i - 1] + arr[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (count[i] - count[j] >= k) {
                    min = Math.min(min, i - j);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
