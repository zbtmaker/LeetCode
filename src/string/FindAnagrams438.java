package string;

import java.util.*;

/**
 * @author Baitao Zou
 * date 2021/05/05
 */
public class FindAnagrams438 {

    /**
     * 滑动窗口，时间复杂度O(N), 空间复杂度O(N)
     *
     * @param s 源字符串
     * @param p 目标字符串
     * @return 子串位置
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> charMapCount = charCount(p);
        int left = 0, right = 0, pLen = p.length();
        List<Integer> list = new LinkedList<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            //如果[left,right]中出现了p中不存在的字符串，左指针向右移动，在移动的同时
            //需要将之前扣减的字符统计恢复成原来的样子
            if (!charMapCount.containsKey(ch)) {
                while (left < right) {
                    char tmpCh = s.charAt(left);
                    charMapCount.put(tmpCh, charMapCount.get(tmpCh) + 1);
                    pLen++;
                    left++;
                }
                left++;
            } else {
                int count = charMapCount.get(ch);
                count--;
                pLen--;
                //如果[left,right]之间出现的字符频率超出了字符串p中出现的频次，同样需要将
                //将之前扣减出来的数据恢复现场
                while (left < right && count < 0) {
                    char tmpCh = s.charAt(left);
                    if (tmpCh == ch) {
                        count++;
                    }
                    charMapCount.put(tmpCh, charMapCount.get(tmpCh) + 1);
                    pLen++;
                    left++;
                }
                charMapCount.put(ch, count);
            }
            //如果[left,right]对应的子串刚好是字符串p的一个排列
            if (pLen == 0) {
                list.add(left);
            }
            right++;
        }
        return list;
    }

    private Map<Character, Integer> charCount(String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
