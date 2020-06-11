package array;

import java.util.*;

/**
 * LeetCode692:https://leetcode-cn.com/problems/top-k-frequent-words/
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * @author baitao zou
 * date 2020/06/11
 */
public class TopKFrequent692 {

    /**
     * TOP-K问题一律采用HashMap和PriorityQueue解决问题，第一步统计每个词出现的次数，
     * 第二步将元素添加到Queue当中，第三步将元素从PriorityQueue中取出。
     *
     * @param words 单词集合
     * @param k     频次最高的元素
     * @return top-k频次的单词
     */
    public List<String> topKFrequent(String[] words, int k) {
        //统计每个字符出现的次数
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        Comparator<String> comparator = (o1, o2) -> {
            if (countMap.get(o2).compareTo(countMap.get(o1)) == 0) {
                return o1.compareTo(o2);
            }
            return countMap.get(o2).compareTo(countMap.get(o1));
        };
        PriorityQueue queue = new PriorityQueue(comparator);
        //采用大顶堆实现
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            queue.add(entry.getKey());
        }
        int i = 0;
        List<String> top = new ArrayList<>(k);
        for (Iterator iterator = queue.iterator(); iterator.hasNext() && i < k; ) {
            top.add((String) queue.poll());
            i++;
        }

        return top;
    }
}
