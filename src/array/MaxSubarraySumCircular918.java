package array;

/**
 * Created by Administrator on 2019\3\1 0001.
 */
public class MaxSubarraySumCircular918 {
    /**
     * 1、暴力方式: time complexity O(N), space complexity O(1)
     *
     * @param A 目标数组
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        return maxSubarraySumCircularByBruteForce(A);
    }

    /**
     * 采用Brute Force方式解决，算法time complexity O(N^2), space complexity O(1).
     *
     * @param A
     * @return
     */
    private int maxSubarraySumCircularByBruteForce(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (A[i] <= 0) {
                continue;
            }
            int sum = A[i];
            for (int j = i + 1; j < (A.length + i); j++) {
                sum += A[j % A.length];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * Brute Force 算法运行时间超了, 那么此时时间复杂度肯定是O(NlogN), O(N), O(logN),
     * 如果是O(NlogN), 那么算法使用的是归并算法(Merge), 如果time complexity为O(N),一个
     * 指针可能搞不定，那么就是双指针搞定，如果time complexity为O(log N), 那么算法大概是
     * Binary Search. 综合分析，time complexity为O(N), 双指针问题。
     *
     * @param A
     * @return
     */
    private int maxSubarraySumCircularByDoublePointer(int[] A) {
        int max = Integer.MAX_VALUE;

        return max;
    }
}
