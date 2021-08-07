package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/09/07
 */
public class PacificAtlantic417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] flag = new boolean[row][col];
                boolean[] can = new boolean[2];
                recur(i, j, matrix, flag, can);
                if (can[0] && can[1]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void recur(int i, int j, int[][] matrix, boolean[][] flag, boolean[] can) {
        if (can[0] && can[1]) {
            return;
        }
        if (flag[i][j]) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if ((i == row - 1 && j == 0) || (i == 0 && j == col - 1)) {
            can[0] = true;
            can[1] = true;
            return;
        }

        flag[i][j] = true;
        //上递归
        if (i - 1 < 0) {
            can[0] = true;
            return;
        }
        if (matrix[i][j] > matrix[i - 1][j]) {
            recur(i - 1, j, matrix, flag, can);
        }

        //下递归
        if (i + 1 >= row) {
            can[1] = true;
            return;
        }
        if (matrix[i][j] > matrix[i + 1][j]) {
            recur(i + 1, j, matrix, flag, can);
        }

        //左递归
        if (j - 1 < 0) {
            can[0] = true;
        }
        if (matrix[i][j] > matrix[i][j - 1]) {
            recur(i, j - 1, matrix, flag, can);
        }

        //右递归
        if (j + 1 >= col) {
            can[1] = true;
        }
        if (matrix[i][j] > matrix[i][j + 1]) {
            recur(i, j + 1, matrix, flag, can);
        }
    }
}
