package array;


import java.util.PriorityQueue;

public class FindKthLargest215 {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargestByPriorityQueue(nums, k);
    }

    /**
     * 借助优先队列思想，我们将所有的元素放入优先队列中，这个时候我们的时间复杂度为O(nlogn)
     *
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargestByPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, Integer::compareTo);
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    /**
     * 快排算法中的partition操作
     *
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargestByPartition(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (true) {
            index = partition(nums, left, right);
            if (index > nums.length - k) {
                right = index - 1;
            } else if (index < nums.length - k) {
                left = index + 1;

            } else {
                return nums[index];
            }
        }

    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left - 1;
        int j = right;
        for (int k = left; k <= right; k++) {
            if (nums[k] <= pivot) {
                swap(nums, i + 1, k);
                i++;
            }

        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
