package string;

import unionfind.WeightedUnionFind;

/**
 * @author baitao zou
 * date 2020/03/12
 */
public class NumSimilarGroups839 {

    private static final int DIFF = 2;

    /**
     * 方法一：暴力算法+并查集算法
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

    private boolean compareString(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length() || str1.equals(str2)) {
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
        return count == DIFF;
    }
}
