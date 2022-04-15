package string;

import java.util.HashMap;
import java.util.Map;

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
     * <p>
     * 2、滑动窗口方式，时间复杂度为O(N),空间复杂度为O(N)
     * <p>
     * 这个题目是在字符串s中找打包含字符t的最小字符子串，我们需要做的是使用HashMap统计字符t中每个字符出现次数。那么我们用left、right
     * 两个指针来维护一个指针，这个窗口内肯定是刚好包含字符串t或者未完全包含字符串t。如果right指针指向的字符是字符t中出现的字符，那么
     * 就需要将字符串的频次-1。那什么时候该移动left指针呢？应该是left和right窗口刚好能够覆盖字符串t的时候，此时，就需要开始移动left
     * 指针，因为left指针可能包含一些不在字符串t中的字符。
     * <p>
     * 这里还有三个个需要解决的，
     * <p>第一个是我们需要用一个min变量来记录我们最小的覆盖字符子串的的长度，同时需要用我们需要一个变量需要最小覆盖子串
     * 时的起始下标，这样在结束时才能知道是字符串s否存在一个字符子串能够覆盖字符串t；
     * <p>第二个问题是我们怎么知道窗口[left, right]已经覆盖了字符串t。用tLen表示字符串t的长度我们每一次right指针移动时，如果right指针
     * 指向的字符是在字符t中，我们每次如果碰到了right指针指向的字符在字符串t中，那么此时就需要将HashMap中对应的字符频次-1。如果这个字符的
     * 频次已经在减之前是大于等于1，的，那么说明此时窗口又多覆盖了一个字符串t的字符，此时应该将tLen - 1，如果此时在减之前这个字符对应的频次
     * 已经是0或者小于0，那么说明窗口[left, right]已经包含了足够多的s.charAt(right)字符串，这时tLen保持不变。就这样，当tLen = 0时，
     * 表明[left, right]指针已经全部覆盖字符串t；
     * <p>第三个问题是当我们的窗口[left, right]覆盖字符串t时，其中包含了一些不在字符t中的字符。这个时候移动left指针，直到[left, right]
     * 指针恰好不覆盖字符串t时，也就是tLen != 0时，此时left指针不再移动。在满足条件的窗口内，每次都需要比较窗口的大小和min的大小，从而更新
     * start指针指向最小覆盖子串的首个位置。
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
