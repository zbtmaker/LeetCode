package math;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class CountPrimes204 {
    /**
     * 小于n内的质数的个数
     *
     * @param n 区间范围
     * @return 质数个数
     */
    public int countPrimes(int n) {
        /*return countPrimeByBruteForce(n);*/
        return countPrimeByMemorization(n);
    }

    /**
     * 参考方法：http://www.puzzles9.com/how-to-find-prime-numbers-how-to-check-if-a-number-is-prime/
     * 这个方法中，求给定范围内的所有质数的数量，我们首先需要判定一个数是否是质数，然后将这个数一直乘以2，那么这些数就
     * 都不是质数了，例如2是质数，如果我们要求10以内的质数数量，那么2 * 1，2 * 2，2 * 3，2 * 4，都可以不用再判断了。
     * @param n
     * @return
     */
    private int countPrimeByMemorization(int n) {
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            if (isPrime(i)) {
                count++;
                int j = 1;
                int num = i;
                while(num < n) {
                    flag[num] = true;
                    j++;
                    num = i * j;
                }

            }
        }
        return count;
    }

    /**
     * 通过暴力的方式来解决,对于区间给定的n,我们需要判断[2,n)内的每一个元素是否为prime。
     *
     * @param n 区间范围
     * @return 质数个数
     */
    private int countPrimeByBruteForce(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断一个数是否是质数
     *
     * @param num 给定的数
     * @return true-质数，false-非质数
     */
    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
