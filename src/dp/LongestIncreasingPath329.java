package dp;

/**
 * Created by Administrator on 2019\3\28 0028.
 */
public class LongestIncreasingPath329 {
    /**
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] cache = new int[row][col];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int result = dfs(i, j, matrix, cache);
                max = Math.max(result, max);
            }
        }
        return max;
    }

    /**
     * 深度优先遍历的方式，对于每个值都进行一遍深度优先遍历，同时采用一个cache数组的方式将已有的结果存储起来。
     * 之前左这个题目有一个误区就是没有将计算结果存储起来，导致重复计算最终超时。这个题目的终极算法是Dynamic
     * Programming，但是目前能力有限，后面再优化这个题目。找一个相似的题目，就是流入大西洋和太平洋的陆地集合
     * leetcode-417太平洋，大西洋流水问题
     * @param i
     * @param j
     * @param matrix
     * @param cache
     * @return
     */
    private int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int max = 0;
        //上
        if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
            int up = dfs(i - 1, j, matrix, cache);
            max = Math.max(up, max);
        }
        //下
        if (i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]) {
            int down = dfs(i + 1, j, matrix, cache);
            max = Math.max(down, max);
        }
        //左
        if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
            int left = dfs(i, j - 1, matrix, cache);
            max = Math.max(left, max);
        }
        //右
        if (j + 1 < matrix[0].length && matrix[i][j] < matrix[i][j + 1]) {
            int right = dfs(i, j + 1, matrix, cache);
            max = Math.max(right, max);
        }
        cache[i][j] = max + 1;
        return cache[i][j];
    }
}
