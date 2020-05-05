package dp;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class IntegerReplacement397 {
    /**
     * method I - Dynamic Programming : time complexity O(N), space complexity O(N)
     * method II - Bit Operate: time complexity O(logN), space complexity O(1)
     *
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        return integerReplacementDP(n);
    }

    /**
     * 采用动态规划的算法思想，我们采用自底向上的思想求解，因为一个大数依赖小数的计算结果，
     * 动态规划三步走，第一步，定义数组存储先前计算的结果；第二步，找到状态转移方程；第三步，
     * 定义初始值。
     * 第一步：定义一维数组dp[i]对于1 <= i <= n,表示i变换到1需要的次数。
     * 第二步：如果i & 1 == 0，表示i是一个偶数，那么此时dp[i] = dp[i >> 1] + 1;
     * 如果i & 1 == 1，表示i是一个奇数，那么此时dp[i] = Math.min(dp[i-1],dp[(i+1) >> 1])+1
     * 第三步：找到初始值，因为是正整数，所以是从1开始计算的，当i = 1时，此时dp[i] = 0
     * time complexity O(N)
     * space complexity O(N)
     * 但是空间复杂度超了，所以空间复杂度可以优化为O(1)
     *
     * @param n
     * @return
     */
    private int integerReplacementDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i >> 1] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1], dp[(i + 1) >> 1] + 1) + 1;
            }
        }
        return dp[n];
    }

    /**
     * 采用移位操作的方式能够解决这个问题
     * 如果一个数是偶数n & 1 == 0，那么n = n >> 1;
     * 如果一个数是奇数n & 1 == 1，那么我们如何减少一次运算呢，也就是我们需要n从右往左的第二位如果是
     * 1，那么如果我们采用对n 采用 n + 1的操作，这样我们就能消灭当前位是一个偶数，而且下一次移位也是偶数，就减少了一次运算。
     * 如果一个数的从右往左的的第二位是0,那么我们此时就采用n-1的操作，这样就能减少一次操作。
     * 这里我们需要考虑Integer.MAX_VALUE，所以需要将n转换成long类型
     *
     * @param n
     * @return
     */
    private int integerReplacementByBitOperator(int n) {
        int count = 0;
        long tmp = n;
        while (tmp != 1) {
            if ((tmp & 1) == 0) {
                tmp >>= 1;
            } else {
                tmp += (tmp & 2) == 0 || tmp == 3 ? -1 : 1;
            }
            count++;
        }
        return count;
    }
}
