package math;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class NthSuperUglyNumber313 {
    /**
     * 这个题目其实就是NthUglyNumber264的扩展题，NthUglyNumber264就是当前题的一种情况，所以解决了一个普遍的问题，
     * 所有的问题就都解决了
     *
     * @param n      丑数数量
     * @param primes 质因素
     * @return 第n个超级丑数
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] index = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int num = primes[j] * dp[index[j]];
                if (min > num) {
                    min = num;
                }
            }
            for (int k = 0; k < primes.length; k++) {
                int num = primes[k] * dp[index[k]];
                if (min == num) {
                    index[k] = index[k] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}
