package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019\2\8 0008.
 */
public class ReverseVowels345 {
    private Set<Character> set = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'));

    /**
     * 反转元音字母，可以借助快排算法思想。
     *
     * @param s 目标字符串
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chs = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < chs.length) {
                if (set.contains(chs[left])) {
                    break;
                }
                left++;
            }
            while (right > -1) {
                if (set.contains(chs[right])) {
                    break;
                }
                right--;
            }
            if (left >= right) {
                break;
            }
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(chs);
    }
}
