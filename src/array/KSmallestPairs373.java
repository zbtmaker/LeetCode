package array;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/06/14
 */
public class KSmallestPairs373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new LinkedList<>();
        }
        return kSmallestPairsByPriorityQueue(nums1, nums2, k);
    }

    /**
     * 采用优先队列的方式实现，算法的时间复杂度和空间复杂度为O(klogk).
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private List<List<Integer>> kSmallestPairsByPriorityQueue(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Pairs> queue = new PriorityQueue<>(nums1.length);
        for (int item : nums1) {
            for (int value : nums2) {
                Pairs pairs = new Pairs(item, value);
                queue.add(pairs);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list;
        int i = 0;
        for (Iterator<Pairs> iterator = queue.iterator(); i < k && iterator.hasNext(); ) {
            Pairs pairs = queue.poll();
            list = new ArrayList<>();
            list.add(pairs.fir);
            list.add(pairs.sec);
            result.add(0, list);
            i++;
        }
        return result;
    }

    private class Pairs implements Comparable<Pairs> {
        private final int fir;
        private final int sec;

        public Pairs(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }

        @Override
        public int compareTo(Pairs o) {
            return Integer.compare(o.fir + o.sec, this.fir + this.sec);
        }
    }
}
