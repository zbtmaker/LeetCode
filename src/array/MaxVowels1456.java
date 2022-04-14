package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/04/14
 */
public class MaxVowels1456 {
    public int maxVowels(String s, int k) {
        int len = s.length(), res = 0, left = 0, right = 0;
        Map<Character, Integer> chMapCount = new HashMap<>();
        while (right < len) {
            char rightCh = s.charAt(right);
            while (right - left + 1 > k) {
                char leftCh = s.charAt(left);
                if (isVowel(leftCh)) {
                    chMapCount.put(leftCh, chMapCount.get(leftCh) - 1);
                }
                left++;
            }
            if (isVowel(rightCh)) {
                chMapCount.put(rightCh, chMapCount.getOrDefault(rightCh, 0) + 1);
            }
            if (right - left + 1 == k) {
                int cur = chMapCount.values().stream().mapToInt(i -> i).sum();
                res = Math.max(res, cur);
            }
            right++;
        }
        return res;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
