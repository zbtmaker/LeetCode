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
        /*return minWindowByBruteForce(s, t);*/
        return minWindowByDoublePoint(s, t);
    }

    /**
     * 滑动窗口方式实现这个方案,使用双指针的方式来实现这个窗口，
     * 算法步骤：算法步骤left、right
     * 1、首先left和right指向同一个位置，紧接着right指针往右走，如果s.substring(left,right + 1)满足条件
     * 2、left往右走，如果发现仍然满足条件，此时就应该缩小窗口的大小，比较窗口大小和之前最小的窗口大小
     * 3、如果此时发现窗口内的字符不能满足条件，此时就应该回到第2步，然后
     *
     * @param s 匹配字符串
     * @param t 目标字符串
     * @return 最小覆盖字符子串
     */
    public String minWindowByDoublePoint(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> needs = initialTargetMap(t);
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int start = 0, min = Integer.MAX_VALUE;
        int match = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (needs.containsKey(ch)) {
                int value = window.get(ch) == null ? 0 : window.get(ch);
                value++;
                window.put(ch, value);
                if (value == needs.get(ch)) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left < min) {
                    start = left;
                    min = right - left;
                }
                char ch2 = s.charAt(left);
                if (needs.containsKey(ch2)) {
                    int curVal = window.get(ch2);
                    int value = Math.max(curVal - 1, 0);
                    window.put(ch2, value);
                    if (value < needs.get(ch2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start
                , min+start);
    }

    /**
     * 通过暴力破解的方式实现结果使得时间复杂度为O(N^2),空间复杂度为O(N)。通过
     * 暴力破解的方式可以看到中间很多操作都是重复的，那么我能不能省略一些操作。实现
     * O(N)的复杂度，空间复杂度为O(N)
     *
     * @param s 匹配字符串
     * @param t 目标字符串
     * @return 最小覆盖字符子串
     */
    private String minWindowByBruteForce(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = initialTargetMap(t);
        int tLen = t.length();

        int min = Integer.MAX_VALUE;
        String minStr = "";
        Map<Character, Integer> srcMap;
        for (int i = tLen - 1; i < s.length(); i++) {
            srcMap = new HashMap<>();
            for (int j = i; j >= 0; j--) {
                char ch = s.charAt(j);
                if (targetMap.containsKey(ch)) {
                    if (srcMap.containsKey(ch)) {
                        srcMap.put(ch, srcMap.get(ch) + 1);
                    } else {
                        srcMap.put(ch, 1);
                    }
                    if (compareMap(srcMap, targetMap)) {
                        if (min > i - j + 1) {
                            min = i - j + 1;
                            minStr = s.substring(j, i + 1);
                        }
                    }

                }
            }
        }
        return minStr;
    }

    /**
     * 统计每个字符出现次数
     *
     * @param t 目标
     * @return
     */
    private Map<Character, Integer> initialTargetMap(String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            if (targetMap.containsKey(ch)) {
                targetMap.put(ch, targetMap.get(ch) + 1);
            } else {
                targetMap.put(ch, 1);
            }
        }
        return targetMap;
    }

    /**
     * 比较两个Map是否是相同的
     *
     * @param srcMap    源字符串统计Map
     * @param targetMap 目标字符串统计结果Map
     * @return 统计结果相同-true，统计结果不同-false
     */
    private boolean compareMap(Map<Character, Integer> srcMap, Map<Character, Integer> targetMap) {
        if (srcMap == null || targetMap == null) {
            return false;
        }
        if (srcMap.size() != targetMap.size()) {
            return false;
        }
        Set<Map.Entry<Character, Integer>> srcEntrySet = srcMap.entrySet();
        boolean flag = srcEntrySet.stream().anyMatch(entry -> {
            char ch = entry.getKey();
            return entry.getValue() < targetMap.get(ch);
        });
        return !flag;
    }
}
