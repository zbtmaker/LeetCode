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
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        Map<Character, Integer> map1 = initialMap(s1);
        Map<Character, Integer> tmp = initialMap(s1);

        for (int i = 0, j = 0; i < len2; i++) {
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

    private Map<Character, Integer> initialMap(String s) {
        Map<Character, Integer> map = new HashMap<>(MAP_SIZE);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
