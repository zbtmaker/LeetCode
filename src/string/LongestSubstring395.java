package string;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/10/06
 */
public class LongestSubstring395 {
    public int longestSubstring(String s, int k) {
        return longestSubstringDivideConquer(s, k);
    }

    /**
     * 采用这种方式的time complexity O(N^2),空间复杂度为O(N)，时间复杂度超出了范围，因此
     * 从这个遍历过程中其实我们发现有一些重复计算，如果我们能够优化一些重复的计算，那么能够简化
     * 时间复杂度，优化思路移动窗口
     *
     * @param s
     * @param k
     * @return
     */
    private int longestSubstringBruteForce(String s, int k) {
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int j = i; j < len; j++) {
                char ch = s.charAt(j);
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
                boolean flag = countMap.entrySet().stream().allMatch(entry -> entry.getValue() >= k);
                if (flag && max < j - i + 1) {
                    max = j - i + 1;
                }
            }
        }
        return max;
    }

    private int longestSubstringDivideConquer(String s, int k) {
        int len = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (countMap.get(ch) < k) {
                indexes.add(i);
            }
        }
        if (indexes.size() == 0) {
            return s.length();
        }
        int left = 0, max = 0;
        indexes.add(len);
        for (Integer index : indexes) {
            String subStr = s.substring(left, index);
            max = Math.max(longestSubstringDivideConquer(subStr, k), max);
            left = index + 1;
        }
        return max;
    }
}
