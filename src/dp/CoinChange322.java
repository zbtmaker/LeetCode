package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\27 0027.
 * 给定不同面额的硬币 coins，其中每种硬币数量可以重复使用。其中coins的数组长度为n,和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 用一个一维的数组来DP记录每个金额所需要的硬币数量，dp(n)表示总量为n时的硬币数量最少。
 * dp(n)=min{dp[n-coin[0]],...dp[n-coin[i]],...dp[n-coin[m]]},i = 0...m
 * <p>
 * 硬币变种(I):就是给定一个coins集合，集合中有重复的元素，但是每种元素只能用一次。
 */
public class CoinChange322 {


    /**
     * 这里需要注意的就是如何进行初始化，光有递推公式不能解决所有的问题。
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

    /**
     * 输出其中一个结果
     *
     * @param coins
     * @param amount
     * @return
     */
    private List<Integer> coinChangeII(int[] coins, int amount) {
        if (amount <= 0) {
            return new ArrayList<>();
        }
        Arrays.sort(coins);
        int[] DP = new int[amount + 1];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < DP.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    break;
                }
                if (DP[i - coins[j]] >= 0) {
                    if (min > DP[i - coins[j]]) {
                        min = DP[i - coins[j]];
                        minIndex = j;
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                DP[i] = min + 1;
                List<Integer> tmpList;
                if (i == coins[minIndex]) {
                    tmpList = new ArrayList<>();
                } else {
                    int index = i - coins[minIndex] - 1;
                    tmpList = new ArrayList<>(result.get(index));
                }
                tmpList.add(coins[minIndex]);
                result.add(tmpList);
            } else {
                DP[i] = -1;
                result.add(new ArrayList<>());
            }
        }
        return result.get(amount - 1);
    }
}
