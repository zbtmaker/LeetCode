package backtracking;


/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * @author baitao zou
 * date 2020/04/20
 */
public class Change518 {
    public int change(int amount, int[] coins) {
        return changeByDynamicProgrammingI(amount, coins);
    }


    /**
     * 参考解法：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
     * 错误思路：这个题目乍一看和硬币兑换是有关系的，其实是没有关系的，这个题目其实就是跳台阶的一个变种，也是从左上角到右下角
     * 有多少种路径的类似题目。相当于是给定一个台阶的总数amount，然后给定一个跳台阶的方式数组coins。既然我们识别了
     * 这个这个问题。这个问题最坏的地方就是我认为这个问题是一个跳台阶问题，但是这个问题和跳台阶是有区别的。我用跳台阶的方式
     * 发现最终的计算的结果。
     * 正确思路：我们用背包问题来解决这类问题，背包问题解决的是什么问题，给定一个背包能够承受的重量为w,然后有一系列物品重量为
     * {w1,w2,...wn},其中每个商品的中价值为{v1,v2,...vn}.我们要使用我们的背包装下总价值最多的商品，而且重量不能超过背包的
     * 重量W。我们首先考虑{w1,...wi},{v1,..vi}，其中1<i<n，同时背包的重量为j,我们用dp[i][j]表示在前i个物品中能够构成的最大
     * 的价值。那么此时可以分为两种情况
     * case1:不包含第i个物品，那么dp[i][j] = dp[i-1][j]
     * case2:包含第i个物品，那么dp[i][j] = dp[i-1][j-wi] + vi.
     * 如果j-wi<0,表明这个物品一定不能选，如果j-wi>=0,那么此时这个物品就变成了可选和可不选，那么我们就需要在选择和不选择里面找一个最大的。
     * <p>
     * 那么我们这个题目其实是背包问题的一个变种，我们就是在给定物品重量{w1,...wn}要找到能够构成背包重量W的方式。
     * 但是我们这里每种物品的变种。我们定义dp[i][j]为前i个物品能够构成的j的种类数。那么我们是不是也可以分为下面两种情况：
     * case1:不包含第i个物品，那么dp[i][j] = dp[i-1][j]，表明我们不需要物品i的重量能够构成j的数量
     * case2:包含第i个物品，那么dp[i][j] = dp[i][j-wi] + dp[i-1][j];
     *
     * @param amount
     * @param coins
     * @return
     */
    private int changeByDynamicProgrammingI(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][amount];
    }


    private int changeByDynamicProgrammingII(int amount, int[] coins) {
        if (amount == 0 && (coins == null || coins.length == 0)) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];

        //初始化dp数组
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i < coin) {
                    continue;
                }
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    /**
     * 找到一个递归范式，这个问题采用回溯算法和combineSum
     *
     * @param amount
     * @param coins
     * @return
     */
    private int changeByBruteForce(int amount, int[] coins) {
        int[] count = new int[1];
        changeRecursive(amount, coins, 0, count);
        return count[0];
    }

    /**
     * 首先需要推导出递归范式，
     *
     * @param amount
     * @param coins
     * @param index
     * @param count
     */
    private void changeRecursive(int amount, int[] coins, int index, int[] count) {
        if (amount == 0) {
            count[0] = count[0] + 1;
            return;
        } else if (amount < 0) {
            return;
        }
        for (int i = index; i < coins.length; i++) {
            amount -= coins[i];
            changeRecursive(amount, coins, i, count);
            amount += coins[i];
        }
    }
}
