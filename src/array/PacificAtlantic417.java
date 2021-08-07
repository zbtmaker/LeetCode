package array;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，
 * 而“大西洋”处于大陆的右边界和下边界。规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或
 * 者在同等高度上流动。请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 *
 * @author baitao zou
 * date 2020/04/05
 */
public class PacificAtlantic417 {

    /**
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] reach = new boolean[row][col];
        List<Integer> arr;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[] flag = new boolean[2];
                dfs(i, j, matrix, flag, reach);
                reach[i][j] = flag[0] & flag[1];

                if (reach[i][j]) {
                    arr = new LinkedList<>();
                    arr.add(i);
                    arr.add(j);
                    result.add(arr);
                }
            }
        }
        return result;
    }

    private boolean dfs(int i, int j, int[][] matrix, boolean[] flag, boolean[][] reach) {
        if (i >= 0 && i < matrix.length
                && j >= 0 && j < matrix[0].length
                && reach[i][j]) {
            flag[0] = true;
            flag[1] = true;

            return true;
        }
        //上
        if (i - 1 < 0) {
            flag[0] = true;
        } else if (matrix[i][j] >= matrix[i - 1][j]) {
            dfs(i - 1, j, matrix, flag, reach);
        }
        //下
        if (i + 1 >= matrix.length) {
            flag[1] = true;
        } else if (matrix[i][j] >= matrix[i + 1][j]) {
            if (dfs(i + 1, j, matrix, flag, reach)) {

            }
        }

        //左
        if (j - 1 < 0) {
            flag[0] = true;
        } else if (matrix[i][j] >= matrix[i][j - 1]) {
            dfs(i, j - 1, matrix, flag, reach);
        }

        //右
        if (j + 1 >= matrix[0].length) {
            flag[1] = true;
        } else if (matrix[i][j] > matrix[i][j + 1]) {
            dfs(i, j + 1, matrix, flag, reach);
        }
        return flag[0] & flag[1];
    }
}
