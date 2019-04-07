package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\27 0027.
 * 给定不同面额的硬币 coins，其中每种硬币数量可以重复使用。其中coins的数组长度为n,和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 用一个一维的数组来DP记录每个金额所需要的硬币数量，DP(n)表示总量为n时的硬币数量最少。
 * DP(n)=min{DP[n-coin[0]],...DP[n-coin[i]],...DP[n-coin[m]]},i = 0...m
 *
 * 硬币变种(I):就是给定一个coins集合，集合中有重复的元素，但是每种元素只能用一次。
 */
public class coinChange322 {
    @Test
    public void test(){
        int count =  new coinChange322().coinChange(new int[]{3,5},7);
        System.out.println(count);
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] DP = new int[amount + 1];
        for (int i = 1; i < DP.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    break;
                }
                if (DP[i - coins[j]] >= 0) {
                    min = Math.min(min, DP[i - coins[j]]);
                }

            }
            if (min != Integer.MAX_VALUE) {
                DP[i] = min + 1;
            } else {
                DP[i] = -1;
            }

        }
        return DP[amount];
    }
}
