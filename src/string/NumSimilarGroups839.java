package string;

import unionfind.WeightedUnionFind;

/**
 * 如果我们交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * 我们给出了一个不包含重复的字符串列表 A。列表中的每个字符串都是 A 中其它所有字符串的一个字母异位词。请问 A 中有多少个相似字符串组？
 *
 * @author baitao zou
 * date 2020/03/12
 */
public class NumSimilarGroups839 {

    private static final int DIFF = 2;

    private static final int ZERO = 0;

    /**
     * 方法一：暴力算法+并查集算法，对于这种题目，如果要求群组的数量，或者是群组的大小，都是采用Union Find算法
     *
     * @param A 目标数组
     * @return 群组个数
     */
    public int numSimilarGroups(String[] A) {
        return numSimilarGroupsByBruteForce(A);
    }

    /**
     * 这个题目通过UnionFind的方式就可以解决，但是我们可以看到
     * 算法的时间复杂度和空间复杂度都很高，time complexity 为
     * O(N^2logN),space complexity为O(N).
     *
     * @param A
     * @return
     */
    private int numSimilarGroupsByBruteForce(String[] A) {
        if (A == null) {
            return 0;
        }
        int sum = 0;
        int len = A.length;
        WeightedUnionFind union = new WeightedUnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (compareString(A[i], A[j])) {
                    union.union(i, j);
                }
            }
        }
        return union.getGroup();
    }

    /**
     * 如果两个字符串上所有位置的字符相等，那么就表明字符串是相似的
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return
     */
    private boolean compareString(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if (count > DIFF) {
                return false;
            }
        }
        return count == ZERO || count == DIFF;
    }
}
