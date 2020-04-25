package string;

/**
 * @author baitao zou
 * date 2020/04/09
 */
public class ValidPalindrome680 {

    public boolean validPalindrome(String s) {
        return validPalindromeII(s);
    }

    private boolean validPalindromeI(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindromeI(i + 1, j, s) || isPalindromeI(i, j - 1, s);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindromeI(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 第一种途径，就是采用暴力的方式解决，那么如何才能不删除任何字符呢，其实
     * 我们可以从-1开始,表示不删除任何字符，判断是否是回文。这种暴力的算法最终
     * 超时，所以还需要好好优化。
     *
     * @param s
     * @return
     */
    public boolean validPalindromeII(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = -1; i < s.length(); i++) {
            if (isPalindromeII(i, s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindromeII(int exclude, String s) {
        int i = 0;
        int j = s.length() - 1;
        if (i == exclude) {
            i++;
        }
        if (j == exclude) {
            j--;
        }
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            if (i == exclude) {
                i++;
            }
            j--;
            if (j == exclude) {
                j--;
            }

        }
        return true;
    }
}
