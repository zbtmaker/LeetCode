package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\1\27 0027.
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少，并输出这个组合。
 * 解题思路：
 * 第一步就是确定一个集合让这个集合中的元素是（比如 1, 4, 9, 16, ...）但是这个集合中最后一个元素一定要小于给定的n
 * 组合的问题主要是要需要将组合输出，所以需要回溯的方法确定组成这个集合的元素。
 */
public class NumSquares279 {

    public int numSquares(int n) {
        /*return numSquareByCombinationSum(n);*/
        return numSquaresByDynamicProgramming(n);
    }

    /**
     * 方法一，就是采用自底向上的方式递归得到我们得数，其实我们还可以自顶向下的
     * 写出我们的递归方程式，这样我们才能写出动态规划算法。
     *
     * @param n
     * @return
     */
    public int numSquareByCombinationSum(int n) {
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        int i = 1;
        while (true) {
            if (i * i <= n) {
                candidates.add(i * i);

            } else {
                break;
            }
            i++;
        }
        return combinationSum(candidates, n);
    }

    public int combinationSum(List<Integer> candidates, int target) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < candidates.size(); i++) {
            sum += candidates.get(i);
            count++;
            min = combinationSum(candidates, target, sum, i, min, count);
            sum = 0;
            count = 0;
        }
        return min;
    }

    private int combinationSum(List<Integer> candidates, int target,
                               int sum, int index, int min, int count) {
        if (sum == target) {
            return Math.min(min, count);
        } else if (sum > target) {
            return min;
        } else {
            for (int i = index; i < candidates.size(); i++) {
                sum += candidates.get(i);
                count++;
                min = combinationSum(candidates, target, sum, i, min, count);
                count--;
                sum -= candidates.get(i);
            }
        }
        return min;
    }

    /**
     * 通过钱币兑换的动态规划算法思想解决问题，这个题目主要设计两个知识点，第一个知识点就是数学上的
     * 质因数分解常用到的，根据这个知识点可以确定硬币集合，但是我们不用存储起来，我们只需要用一个最大的
     * 硬币maxCoin = Math.sqrt(n)存储起来就好了。然后就是钱币兑换问题的动态规划解法。很显然这个题目还有可以
     * 优化的空间。
     *
     * @param n
     * @return
     */
    private int numSquaresByDynamicProgramming(int n) {
        int maxCoin = (int) Math.sqrt(n);
        if (maxCoin * maxCoin == n) {
            return 1;
        }
        return coinChange((int) Math.sqrt(n), n);
    }

    private int coinChange(int maxCoin, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= maxCoin; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= maxCoin; j++) {
                int square = j * j;
                if (i >= square && dp[i - square] + 1 < min) {
                    min = dp[i - square] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
