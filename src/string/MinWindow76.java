package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode76 :https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 双指针算法参考链接:https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hua-dong-chuang-kou-ji-qiao
 *
 * @author baitao zou
 * date 2020/01/31
 */
public class MinWindow76 {

    /**
     * 1、暴力破解方式，时间复杂度为O(N^2),空间复杂度O(N)
     * 2、滑动窗口方式，时间复杂度为O(N),空间复杂度为O(N)
     *
     * @param s 匹配字符串
     * @param t 目标字符串
     * @return 最小覆盖子串
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> charMapCount = charCount(t);
        int left = 0, right = 0, sLen = s.length(), tLen = t.length(), start = -1, min = Integer.MAX_VALUE;
        while (right < sLen) {
            char rightCh = s.charAt(right);
            Integer rightChCount = charMapCount.get(rightCh);
            if (rightChCount != null) {
                --rightChCount;
                if (rightChCount >= 0) {
                    tLen--;
                }
                charMapCount.put(rightCh, rightChCount);
            }
            while (tLen == 0) {
                if (min > right - left + 1) {
                    start = left;
                    min = right - left + 1;
                }
                char leftCh = s.charAt(left);
                Integer leftChCount = charMapCount.get(leftCh);
                if (leftChCount != null) {
                    ++leftChCount;
                    if (leftChCount > 0) {
                        ++tLen;
                    }
                    charMapCount.put(leftCh, leftChCount);
                }
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    private Map<Character, Integer> charCount(String s) {
        Map<Character, Integer> charMapCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charMapCount.put(ch, charMapCount.getOrDefault(ch, 0) + 1);
        }
        return charMapCount;
    }
}
