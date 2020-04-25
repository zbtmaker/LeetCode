package string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author Baitao Zou
 * date 2019\3\9
 */
public class IsPalindrome125 {
    /**
     * 双指针以及快熟排序中的partition思想，打败94%的用户，不用优化
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0;
        int j = len - 1;

        while (i <= j) {
            while (i < len &&
                    !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                            (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                            (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                i++;
            }
            while (j > -1 &&
                    !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') ||
                            (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') ||
                            (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                j--;
            }
            if (i < j) {
                char left = s.charAt(i);
                if (left <= 'Z') {
                    left = (char) (left + 32);
                }
                char right = s.charAt(j);
                if (right <= 'Z') {
                    right = (char) (right + 32);
                }
                if (left != right) {
                    return false;
                }
            }
            i++;
            j--;

        }
        return true;
    }
}
