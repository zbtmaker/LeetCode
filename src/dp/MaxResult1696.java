package dp;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zoubaitao
 * date 2022/10/09
 */
public class MaxResult1696 {

    /**
     * 这里每个节点可以遍历的范围为i+1, i+2 ,... i + k
     * time complexity O(NK)
     * space complexity O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxResult(int[] nums, int k) {
        return priorityQueue(nums, k);
    }

    /**
     * 这里每个节点可以遍历的范围为i+1, i+2 ,... i + k，使用一个数组将
     * 最小的数据存储起来。这样就不会出现重复计算的问题。
     * time complexity O(NK)
     * space complexity O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    private int memorize(int[] nums, int k) {
        int len = nums.length;
        int[] F = new int[len];
        Arrays.fill(F, Integer.MIN_VALUE);
        F[0] = nums[0];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + k && j < len; j++) {
                F[j] = Math.max(F[j], F[i] + nums[j]);
            }
        }
        return F[len - 1];
    }

    /**
     * 这个题目和滑动窗口平均值这个题目有点像，其实我们只要维持一个大小为k + 1
     * 的窗口就行，我们每次移动都需要判断移动前第二小的数值，然后将第二小的数值
     * 和移动进来的元素相加之后添加到窗口中，然后每次移动，相当于移动了N-K次，同时
     * 执行了N次加入窗口的操作和移除出窗口的操作，这样窗口内的操作时间复杂度约为logK，
     * 那么移动N次，总的时间复杂度为O(NlogK)。这样我们的时间复杂度从原本的O(NK)，降低
     * 为O(NlogK).而空间复杂度从原来的O(N)，降低为现在的O(K)。
     *
     * @return
     */
    private int priorityQueue(int[] nums, int k) {
        int len = nums.length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(nums[0]);
        for (int i = 1; i < len; i++) {
            if (i - k > 0) {
                int cur = queue.peekFirst();
                if (nums[i - k - 1] == cur) {
                    queue.removeFirst();
                }
            }
            int max = queue.peekFirst();
            int cur = max + nums[i];
            while (!queue.isEmpty() && queue.peekLast() < cur) {
                queue.pollLast();
            }
            queue.addLast(cur);
            nums[i] = cur;
        }
        return nums[len - 1];
    }
}
