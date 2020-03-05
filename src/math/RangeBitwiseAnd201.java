package math;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 参考: https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 *
 * @author baitao zou
 * date 2020/03/01
 */
public class RangeBitwiseAnd201 {

    /**
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        /*return rangeBitwiseAndBruteForce(m, n);*/
        return rangeBitwiseAndBinarySearch(m, n);
    }

    /**
     * 暴力算法：依次累加, time complexity O(N), 时间超了。因此最好的算法时间复杂度
     * 是O(logN).
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAndBruteForce(int m, int n) {
        if (m == 0 || m == Integer.MAX_VALUE) {
            return m;
        }
        int sum = m;
        for (int i = m + 1; i <= n; i++) {
            sum &= i;
            if (sum == 0 || i == Integer.MAX_VALUE) {
                break;
            }
        }
        return sum;
    }

    /**
     * 算法的精髓就是判断一个[m,n]是否存在一个2的次幂在这个区间当中，
     * 1、存在一个2的次幂在[m,n]中，如果2^bit== m, 此时输出最小值m, 如果m < 2^bit <= n, 此时就应该返回最小值
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAndBinarySearch(int m, int n) {
        /*if (m == 0 || m == Integer.MAX_VALUE) {
            return m;
        }

        long bit = 1;
        while (bit < m && bit < n ) {
            bit = bit << 1;
        }
        if (bit == m) {
            return m;
        }
        if (bit > m && bit <= n) {
            return 0;
        }
        int sum = m;
        if (bit > m) {

            for (int i = m + 1; i <= n; i++) {
                sum &= i;
            }
        }*/
        return 0;
    }
}
