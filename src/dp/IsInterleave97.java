package dp;

/**
 * @author baitao zou
 * date 2020/05/29
 */
public class IsInterleave97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaveByRecursion(s1, s2, s3);
    }


    /**
     * 第一种暴力的思想是，我们得到s1的所有分割情况，然后得到s2的所有分割情况，然后就能
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @param s3 目标字符串
     * @return
     */
    private boolean isInterleaveByRecursion(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        return recur(s1, 0, s2, 0, s3, 0);
    }

    private boolean recur(String s1, int i,
                          String s2, int j,
                          String s3, int k) {
        if (k == s3.length()) {
            return true;
        }
        boolean isValid = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isValid = recur(s1, i + 1, s2, j, s3, k + 1);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isValid = isValid || recur(s1, i, s2, j + 1, s3, k + 1);
        }
        return isValid;
    }
}
