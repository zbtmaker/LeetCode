package array;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/06/04
 */
public class TopKFrequent347 {
    /**
     * TOP-K问题一律采用HashMap和PriorityQueue解决问题，第一步统计每个词出现的次数，
     * 第二步将元素添加到Queue当中，第三步将元素从PriorityQueue中取出。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        //统计每个字符出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Comparator<Integer> comparator = (o1, o2) -> countMap.get(o2).compareTo(countMap.get(o1));
        PriorityQueue queue = new PriorityQueue(comparator);
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        //采用大顶堆实现
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            queue.add(entry.getKey());
        }
        int i = 0;
        int[] top = new int[k];
        for (Iterator iterator = queue.iterator(); iterator.hasNext() && i < k; ) {
            top[i++]= (int)queue.poll();
        }

        return top;
    }

    /**
     * 桶排序实现算法
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] topKFrequentByBucketSort(int[] nums, int k) {
        return null;
    }
}
