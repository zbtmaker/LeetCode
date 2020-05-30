package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baitao zou
 * date 2020/05/30
 */
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE, match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (!set.contains(c1)) {
                max = Math.max(right - left + 1, max);
            } else {
                while (set.contains(c1)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(c1);
            right++;
        }
        return max;
    }
}
