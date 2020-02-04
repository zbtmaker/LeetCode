package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
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
        return minWindowByBruteForce(s, t);
    }

    /**
     * 滑动窗口方式实现这个方案
     *
     * @param s 匹配字符串
     * @param t 目标字符串
     * @return 最小覆盖字符子串
     */
    public String minWindowBySlidingWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = initialTargetMap(t);
        int tLen = t.length();
        for (int i = tLen - 1; i < s.length(); i++) {

        }
        return null;
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
    public String minWindowByBruteForce(String s, String t) {
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
