package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Baitao Zou
 * date 2021/03/20
 */
public class CheckInclusion567 {
    private static final int MAP_SIZE = 32;

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        return checkInclusionByArr(s1, s2);
    }

    /**
     * 1、采用HashMap的方式解决问题，用Set统计字符串s1中每个字符，然后用一个临时的HashMap来存储s1中每个字符出现的频次。
     * 2、遍历字符串s2，如果出现s2中的字符不是s1中的字符，此时需要重新两个指针需要重新计算，同时也需要将HashMap统计结果进行重新计算
     * 3、如果出现s2中字符数超出了s1的字符数，则需要将滑动窗口缩小，直到窗口能够满足我们的条件为止
     *
     * @param s1
     * @param s2
     * @return
     */
    private boolean checkInclusionByMap(String s1, String s2) {
        Map<Character, Integer> map1 = initialMap(s1);
        Map<Character, Integer> tmp = initialMap(s1);

        for (int i = 0, j = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!map1.containsKey(ch)) {
                tmp = initialMap(s1);
                j = i + 1;
            } else {
                if (tmp.containsKey(ch)) {
                    int count = tmp.get(ch);
                    if (count == 1) {
                        tmp.remove(ch);
                    } else {
                        tmp.put(ch, count - 1);
                    }
                } else {
                    while (j <= i) {
                        char tmpChar = s2.charAt(j);
                        j++;
                        if (tmpChar == ch) {
                            break;
                        }
                        tmp.put(tmpChar, tmp.getOrDefault(tmpChar, 0) + 1);
                    }
                }

            }
            if (tmp.size() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 因为字符串中只包含小写字字母，所以采用固定长度为26的数组会很方便
     * 采用两个数组的方式，count数组用于统计s1每个字符出现的次数，flag数组用于统计s2每个字符是否出现，剩下的窗口滑动的步骤就喝上面的
     * 一致了
     *
     * @param s1
     * @param s2
     * @return
     */
    private boolean checkInclusionByArr(String s1, String s2) {
        //初始化窗口数据
        int[] flag = initFlagArr(s1), count = initCountArr(s1);
        int len = s1.length();
        //遍历目标数组
        for (int i = 0, j = 0; i < s2.length(); i++) {
            int ch = s2.charAt(i) - 'a';
            //完全不满足窗口条件，则初始化窗口数据
            if (flag[ch] == 0) {
                count = initCountArr(s1);
                j = i + 1;
                len = s1.length();
            } else {
                //操作窗口元素
                count[ch]--;
                len--;
                //局部不满足窗口条件则滑动窗口左指针直到满意为止
                while (j <= i && count[ch] < 0) {
                    int tmpChar = s2.charAt(j) - 'a';
                    j++;
                    count[tmpChar]++;
                    len++;
                }
            }
            if (len == 0) {
                return true;
            }
        }
        return false;
    }

    private int[] initFlagArr(String s) {
        int[] flag = new int[26];
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 'a'] = 1;
        }
        return flag;
    }

    private int[] initCountArr(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

    private Map<Character, Integer> initialMap(String s) {
        Map<Character, Integer> map = new HashMap<>(MAP_SIZE);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
