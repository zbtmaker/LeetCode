package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Baitao Zou
 * date 2021/04/18
 */
public class CompressionII1531 {
    private int min;

    public int getLengthOfOptimalCompression(String s, int k) {
        return getLengthOfOptimalCompressionBottomUpRecur(s, k);
    }

    /**
     * 自底向上递归
     *
     * @param s 字符串
     * @param k 待删除的字符
     * @return 最短压缩字符串长度
     */
    private int getLengthOfOptimalCompressionBottomUpRecur(String s, int k) {
        min = s.length();
        recur(s, k, 0, new HashSet<>());
        return this.min;
    }

    private void recur(String s, int k, int index, Set<Integer> set) {
        if (k == 0) {
            min = Math.min(compress(s, set), min);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            set.add(i);
            k--;
            recur(s, k, i + 1, set);
            k++;
            set.remove(i);
        }
    }

    private int compress(String s, Set<Integer> set) {
        int result = 0, i = 0;
        while (i < s.length()) {
            if (set.contains(i)) {
                i++;
            } else {
                result++;
                int j = i + 1, count = 1;
                while (j < s.length() && (set.contains(j) || s.charAt(j) == s.charAt(i))) {
                    if (!set.contains(j)) {
                        count++;
                    }
                    j++;
                }
                if (count > 1) {
                    result += String.valueOf(count).length();
                }
                i = j;
            }
        }
        return result;
    }


    /**
     * 自顶向下递归
     *
     * @param s 字符串
     * @param k 待删除的字符
     * @return 最短压缩字符串长度
     */
    private int getLengthOfOptimalCompressionTopDownRecur(String s, int k) {
        return 0;
    }
}
