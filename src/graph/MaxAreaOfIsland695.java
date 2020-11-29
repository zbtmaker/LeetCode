package graph;

/**
 * @author baitao zou
 * date 2020/11/29
 */
public class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[] flag = new boolean[row * col];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int area = dfs(grid, i, j, flag);
                max = Math.max(max, area);
            }
        }
        return max;
    }


    private int dfs(int[][] grid, int i, int j, boolean[] flag) {
        int row = grid.length, col = grid[0].length, result = 0;
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return result;
        }
        if (grid[i][j] == 0) {
            return result;
        }

        if (flag[i * col + j]) {
            return result;
        }

        flag[i * col + j] = true;
        result++;

        result += dfs(grid, i + 1, j, flag);
        result += dfs(grid, i - 1, j, flag);
        result += dfs(grid, i, j + 1, flag);
        result += dfs(grid, i, j - 1, flag);

        return result;
    }
}
