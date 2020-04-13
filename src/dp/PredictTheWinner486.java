package dp;

/**
 * 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * <p>
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 *
 * @author baitao zou
 * date 2020/04/13
 */
public class PredictTheWinner486 {
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

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        Pair[][] dp = new Pair[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                dp[i][j] = i == j ? new Pair(nums[i], 0) : new Pair(0, 0);
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int left = nums[i] + dp[i + 1][j].sec;
                int right = nums[j] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        return dp[0][len - 1].fir >= dp[0][len - 1].sec;
    }
}
