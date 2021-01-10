package string;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/05/30
 */
public class FindSubstring30 {
    /**
     * 这个题目是要在s中找到所有在words中所有的字串，因为字串是连续的，因此我们可以维护一个长度为words所有字符串长度
     * 的窗口，然后判断这个窗口内所有字符的构成是否满足words的长度，然后每次移动一步来移动窗口。
     * 时间复杂度和空间复杂度待优化
     *
     * @param s     字符串
     * @param words 目标字符串
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> index = new LinkedList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return index;
        }

        int total = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String word : words) {
            int curLen = word.length();
            total += curLen;
            min = Math.min(curLen, min);
            max = Math.max(curLen, max);
        }
        int len = s.length();
        for (int i = 0, j = total - 1; i < len - total + 1 && j < len; i++, j++) {
            Map<String, Integer> wordsMapCount = new HashMap<>();
            for (String word : words) {
                wordsMapCount.put(word, wordsMapCount.getOrDefault(word, 0) + 1);
            }
            int start = i, k = i;
            for (; k <= j; k++) {
                if (k - start + 1 < min) {
                    continue;
                }
                if (k - start + 1 > max) {
                    break;
                }
                String substring = s.substring(start, k + 1);
                Integer count = wordsMapCount.get(s.substring(start, k + 1));
                if (count != null && count > 0) {
                    if (count == 1) {
                        wordsMapCount.remove(substring);
                    } else {
                        wordsMapCount.put(substring, count - 1);
                    }
                    start = k + 1;
                }
            }
            if (wordsMapCount.isEmpty()) {
                index.add(i);
            }
        }
        return index;
    }
}
