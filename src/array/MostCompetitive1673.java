package array;

import java.util.ArrayDeque;

/**
 * @author Baitao Zou
 * date 2021/03/23
 */
public class MostCompetitive1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        WindowQueue windowQueue = new WindowQueue(k);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            windowQueue.push(nums[i], len - i);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = windowQueue.poll();
        }
        return result;
    }

    private class WindowQueue {
        private ArrayDeque<Integer> arrayDeque;

        private int k;

        public WindowQueue(int k) {
            arrayDeque = new ArrayDeque<>();
            this.k = k;
        }

        public void push(int val, int size) {
            while (!arrayDeque.isEmpty() && arrayDeque.size() + size > k && arrayDeque.peekLast() > val) {
                arrayDeque.pollLast();
            }
            arrayDeque.addLast(val);
        }

        public int poll() {
            return arrayDeque.pollFirst();
        }
    }
}
