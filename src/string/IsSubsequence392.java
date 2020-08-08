package string;

/**
 * Created by Administrator on 2019\1\27 0027.
 */
public class IsSubsequence392 {
    /**
     * 这里采用双指针的方式来判断，只要是t字符串中有一个元素和s字符串中元素相同，那么s字符串的指针位置就往后移一位，
     * 这样我们就能保证这个字符串s中所有的字符都能够包含在t字符串中
     *
     * @param s 源字符串
     * @param t 目标字符串
     * @return true-是 ｜ false-不是
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0, sLen = s.length(), tLen = t.length();
        for (int j = 0; i < sLen && j < tLen; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == tLen;
    }
}
