package math;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class NthUglyNumber264 {

    /**
     * 1、使用暴力的方式来求解，这种方式主要是从i = 1开始增加，count用于记录是第几个丑数。然后判断这个数是否是丑，如果是则count++。直到count == n。
     * 2、从这里我们可以发现，其实有很多的重复计算，那么我们用一个HashSet来存储我们之前计算过的丑数。因为大的丑数总是等于小的丑数乘以2、3、5。
     * 3、第二种方式使用HashSet保存之前的丑数，但是遍历了每一个数，实际上我们需要的是丑数，那么后面的丑数肯定是前面的丑数乘以2、3、5得到的。
     * 所以我们只需要将最新得到的丑数乘以2、3、5就可以得到最终结果
     *
     * @param n 丑数数量
     * @return 第n个丑数
     */
    public int nthUglyNumber(int n) {
        return nthUglyNumberByOpt(n);
    }

    /**
     * 暴力的方式：从i = 1开始增加，count用于记录是第几个丑数。然后判断这个数是否是丑，如果是则count++。直到count == n。
     *
     * @param n 数量
     * @return 第n个丑数
     */
    private int nthUglyNumberByBruteForce(int n) {
        int i = 1;
        int count = 0;
        while (true) {
            if (isUglyByBruteForce(i)) {
                count++;
            }
            if (count == n) {
                return i;
            }
            i++;
        }
    }

    /**
     * 判断一个数是否是丑数
     *
     * @param num 目标数
     * @return true-是丑数，false-不是丑数
     */
    private boolean isUglyByBruteForce(int num) {
        if (num < 1) {
            return false;
        }
        while (num != 1) {
            boolean flag = true;
            if (num % 2 == 0) {
                num = num / 2;
                flag = false;
            } else if (num % 3 == 0) {
                num = num / 3;
                flag = false;
            } else if (num % 5 == 0) {
                num = num / 5;
                flag = false;
            }
            if (flag) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这种方式主要是用一个HashSet存储之前的丑数，如果一个num除以质因数2、3、5在HashSet当中，肯定是一个丑数，否则不是。
     * count用于记录丑数的数量，如果count == n,此时退出循环。
     *
     * @param n
     * @return
     */
    private int nthUglyNumberByMemoization(int n) {
        Set<Integer> uglySet = new HashSet<>(n);
        uglySet.add(1);
        int count = 0;
        int i = 1;
        while (true) {
            if (isUglyByMemorization(i, uglySet)) {
                count++;
                uglySet.add(i);
            }
            if (count == n) {
                return i;
            }
            i++;
        }
    }

    /**
     * 通过这种记录之前的丑数方式，如果目标树num除以质因数2，3，5之后，如果是一个丑数，
     * 肯定会在uglySet，如果不在，那么肯定
     *
     * @param num
     * @param uglySet
     * @return
     */
    private boolean isUglyByMemorization(int num, Set<Integer> uglySet) {
        if (num < 1) {
            return false;
        }
        if (num % 2 == 0) {
            num = num / 2;
        } else if (num % 3 == 0) {
            num = num / 3;
        } else if (num % 5 == 0) {
            num = num / 5;
        }
        if (uglySet.contains(num)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 这种方式确实最难的是如果找到下一个Ugly Number。这里采用三个指针i2、i3、i5。
     * 每次都找到哪个最小值，然后写入到动态规划的数组dp用来记录后面的数组。这里采用
     * 具体见下面的实现
     *
     * @param n
     * @return
     */
    private int nthUglyNumberByOpt(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }

        return dp[n - 1];
    }
}
