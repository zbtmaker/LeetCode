package dp;

/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 *
 * @author Baitao Zou
 * date 2020/05/12
 */
public class CalculateMinimumHP174 {
    /**
     * 这个题目的宗旨还是动态规划，但是这个问题和之前的问题有一点不同的是
     * 我们要找到那个能到达终点的所需最小能量的路径。之前我们需要的是最短的
     * 路径达到终端，我们用动态规划能够解决这个问题吗，我想应该是可以的。但是
     * 我们应该怎样记录却成为了以问题。
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        return dfs(dungeon, dungeon.length - 1, dungeon[0].length - 1);
    }

    private int dfs(int[][] dungeon, int rowIndex, int colIndex) {
        if (rowIndex < 0 || colIndex < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Math.min(dfs(dungeon, rowIndex - 1, colIndex), dfs(dungeon, rowIndex, colIndex - 1));
        return dungeon[rowIndex][colIndex] <= 0 ? dungeon[rowIndex][colIndex] + 1 + min : min;
    }
}
