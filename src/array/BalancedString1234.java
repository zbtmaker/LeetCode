package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/04/14
 */
public class BalancedString1234 {

    /**
     * 1、使用len表示字符串s的长度，我们用一个HashMap统计字符'Q'、'W'、'E'、'R'这四个字符的
     * 长度。然后用len/4分别和每一个字符的频次取比较，如果字符的频次比len/4大，那么就需要被替换掉
     * 如果字符出现的频次比len/4小，那么不需要被替换。
     * <p>
     * 2、上面统计完成之后，这个题目其实就转化成最小覆盖子串的问题了，比方说，我们这个里面多了两个Q和3个W
     * 以及一个R，那么就是在字符串s中寻找一个最小能够覆盖子串QQWWWR的一个子串（Leetcode76），此题结束。
     *
     * @param s 字符
     * @return 最小替换子串长度
     */
    public int balancedString(String s) {
        Map<Character, Integer> charMapCount = getChMapCount(s);
        if (charMapCount.size() == 0) {
            return 0;
        }
        int tLen = charMapCount.values().stream().mapToInt(i -> i).sum();
        int len = s.length();
        int left = 0, right = 0, min = len;
        while (right < len) {
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
        return min;
    }

    private Map<Character, Integer> getChMapCount(String s) {
        Map<Character, Integer> chMapCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            chMapCount.put(ch, chMapCount.getOrDefault(ch, 0) + 1);
        }
        int len = s.length();
        int avg = len / 4;
        Map<Character, Integer> map = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : chMapCount.entrySet()) {
            int freq = entry.getValue();
            if (freq > avg) {
                map.put(entry.getKey(), freq - avg);
            }
        }
        return map;
    }
}
