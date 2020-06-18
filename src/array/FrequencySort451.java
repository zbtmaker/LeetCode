package array;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/06/14
 */
public class FrequencySort451 {
    /**
     * 此题同样采用优先队列解决问题
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        Comparator<Character> comparator = (ch1, ch2) -> countMap.get(ch2).compareTo(countMap.get(ch1));
        PriorityQueue<Character> queue = new PriorityQueue<>(comparator);
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            queue.add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (Iterator<Character> iterator = queue.iterator(); iterator.hasNext(); ) {
            Character ch = queue.poll();
            for (int i = 0; i < countMap.get(ch); i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
