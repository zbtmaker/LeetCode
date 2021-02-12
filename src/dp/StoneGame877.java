package dp;

import java.util.Arrays;

/**
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * 链接：https://leetcode-cn.com/problems/stone-game
 *
 * @author baitao zou
 * date 2020/04/13
 */
public class StoneGame877 {
    private int maxVal = Integer.MIN_VALUE;
    private int minVal = Integer.MAX_VALUE;

    static class Pair {
        //先手
        int fir;
        //后手
        int sec;

        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

    /**
     * 参考解法：https://leetcode-cn.com/problems/stone-game/solution/jie-jue-bo-yi-wen-ti-de-dong-tai-gui-hua-tong-yong/
     * 1、这里我们可以看到就是两个人在博弈，其中，我们需要理解的就是先手和后手的概念。当先手选择完了以后就变成了后手，后手选择完了以后就比那成了先手。
     * 我们用fir表示先手，sec表示后手。我们需要将先后手能够取得的最大值都保存起来，其中用dp数组来保存某一段子堆（相当于子数组）fir和sec能够取得的
     * 最大值从任意一个人来看，只能够从左边或者右边选取一个堆，但是
     * 先手的递推关系：dp(i,j).fir = max{piles(i))+dp(i+1,j).sec, piles(j)+dp(i,j-1)sec}。因为每个用户
     * 如果先手选择完了，如果先手选择完了左边，那么先手就是选择了piles(i)，那么sec就只能在(i+1,j)最大化了。如果fir选择了piles(j)，那么sec就只能
     * 在(i,j-1)内取得最大值。因此fir和sec的递推关系如下：
     * dp(i,j).fir = max{piles(i))+dp(i+1,j).sec, piles(j)+dp(i,j-1).sec}
     * if(piles(i) + dp(i+1,j).sec > piles(j) + dp(i,j-1).sec)
     * dp(i,j).sec = dp(i+1,j).fir
     * if(piles(i) + dp(i+1,j).sec <= piles(j) + dp(i,j-1).sec)
     * dp(i,j).sec = dp(i+1,j).fir
     * <p>
     * 2、但是如果i==j的时候，表示堆的长度为1，那么这个时候能够拿到堆piles(i)的长度dp(i,i).fir = piles(i)，因此后手拿不到任何堆，因此dp(i,i).sec=0
     * <p>
     * 3、我们要求dp(0,len-1),会发现求dp(0,len-1),要以来dp(1,len - 1)和dp(0,len-2)。所以我们需要从矩阵
     * 中从左往右求解，从下往上求解矩阵中每一个值
     * <p>
     * 4、最后就只需要判断dp(0,len-1).fir >= dp(0,len).sec
     * 其实这种方式实现是对的，但是当你理解这个问题来还是有点障碍，其实问题确实可以理解成前后手问题，但是前后手问题我的理解是无数种选择造就了
     *
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        return stoneGameNegamax(piles);
    }

    private boolean stoneGameByUpDown(int[] piles) {
        int len = piles.length;
        Pair[][] dp = new Pair[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                dp[i][j] = i == j ? new Pair(piles[i], 0) : new Pair(0, 0);
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        return dp[0][len - 1].fir > dp[0][len - 1].sec;
    }

    /**
     * 这个问题是一个Zero-sum game，理论上是可以用minmax算法解决问题，但是根据wiki中采用negamax算法可以解决
     * 问题。我根据negamax算法的理解就是maxPlayer的最大值，然后minPlayer的最小值，其实就是可以理解为maxPlayer - minPlayer
     * 我们要找到这个差值的最大值。对于zero-sum game就是给定一个utility function，这个utility function其实是MaxPlayer的，但是
     * minPlayer的目标是就是最小化这个maxPlayer的utility function。
     *
     * @param piles 石头堆
     * @return 最大石头堆
     */
    private boolean stoneGameNegamax(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int result = negamax(piles, 0, len - 1, dp);
        int sum = Arrays.stream(piles).sum();
        int maxPlayer = (result + sum) >> 1;
        return maxPlayer > sum - maxPlayer;
    }

    private int negamax(int[] piles, int left, int right, int[][] dp) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != Integer.MAX_VALUE) {
            return dp[left][right];
        }
        dp[left][right] = Math.max(piles[left] - negamax(piles, left + 1, right, dp),
                piles[right] - negamax(piles, left, right - 1, dp));
        return dp[left][right];
    }
}
