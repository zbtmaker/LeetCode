package dp;

/**
 * @author Baitao Zou
 * date 2020/12/27
 */
public class WinnerSquareGame1510 {
    /**
     * 这个题目和硬币兑换有点相似，但是不同的是，这里是两个人操作，
     * 每个人都会在下一个人操作的时候都会选择自己利益最大，而让对方
     * 的获益最小。因此如果playerA在一个子问题上存在playerA取的不是最后一个
     * 元素，那么此时如果playerA可以在前一步走到这个子问题，那么playerB
     * @param n
     * @return
     */
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j * j <= i) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                }
                j++;
            }
        }
        return dp[n];
    }
}
