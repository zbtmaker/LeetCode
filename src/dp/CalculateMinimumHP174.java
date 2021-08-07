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
        int row = dungeon.length;
        int col = dungeon[0].length;
        Pair[][] pairs = init(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    if (dungeon[i][j] >= 0) {
                        pairs[i][j].min = 1;
                    } else {
                        pairs[i][j].min = -dungeon[i][j] + 1;
                    }
                } else if (i == 0) {

                } else if (j == 0) {

                } else {

                }
                int rowMin;
                if (dungeon[i][j] + pairs[i - 1][j].res < 0) {
                    rowMin = dungeon[i - 1][j - 1] + pairs[i - 1][j].res;
                } else {
                    rowMin = pairs[i - 1][j].min;
                }
                int colMin;
                if (dungeon[i - 1][j - 1] + pairs[i][j - 1].res < 0) {
                    colMin = dungeon[i - 1][j - 1] + pairs[i][j - 1].res;
                } else {
                    colMin = pairs[i][j - 1].min;
                }
                if (rowMin < colMin) {
                    pairs[i][j].min = colMin;
                    pairs[i][j].res = dungeon[i - 1][j - 1] + pairs[i][j - 1].res;
                } else {
                    pairs[i][j].min = rowMin;
                    pairs[i][j].res = dungeon[i - 1][j - 1] + pairs[i - 1][j].res;
                }
            }
        }
        return pairs[row][col].min < 0 ? -pairs[row][col].min : 0;
    }

    public Pair[][] init(int row, int col) {
        Pair[][] pairs = new Pair[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pairs[i][j] = new Pair(0, 0);
            }
        }
        return pairs;
    }

    private class Pair {
        /**
         * 到达某个位置需要的最小的HP
         */
        private int min;

        /**
         * 达到某个位置剩余的HP
         */
        private int res;

        public Pair() {
            this(0, 0);
        }

        public Pair(int min, int res) {
            this.min = min;
            this.res = res;
        }
    }
}
