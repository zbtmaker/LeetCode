package backtracking;

/**
 * Created by Administrator on 2019\3\21 0021.
 */
public class LongestIncreasingPath329 {

    // 方向数组
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 1、回溯
     * 2、回溯+记忆化
     *
     * @param matrix 矩阵数组
     * @return 最长增长路径长度
     */
    public int longestIncreasingPath(int[][] matrix) {
        return byMemorization(matrix);
    }

    /**
     * 使用上面的DFS + 记忆数组
     *
     * @param matrix 矩阵数组
     * @return 最长增长路径长度
     */
    public int byMemorization(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length, max = 1;
        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int result = dfs(i, j, matrix, cache);
                max = Math.max(result, max);
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int max = 0, row = matrix.length, col = matrix[0].length;
        for (int[] direction : DIRECTIONS) {
            int m = i + direction[0], n = j + direction[1];
            if (m > -1 && m < row && n > -1 && n < col && matrix[i][j] < matrix[m][n]) {
                int res = dfs(m, n, matrix, cache);
                max = Math.max(res, max);
            }
        }
        cache[i][j] = max + 1;
        return cache[i][j];
    }
}
