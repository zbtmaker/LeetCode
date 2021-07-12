package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baitao zou
 * date 2020/05/30
 */
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while(left < i && set.contains(ch)) {
                set.remove(s.charAt(left ++));
            }
            set.add(ch);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
