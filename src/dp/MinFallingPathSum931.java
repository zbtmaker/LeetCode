package dp;

/**
 * Created by Administrator on 2019\1\26 0026.
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 */
public class MinFallingPathSum931 {

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        if (row == 1) {
            return matrix[0][0];
        }
        int[][] DP = new int[row + 1][row];
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < row; j++) {
                if (j == 0) {
                    DP[i][j] = Math.min(DP[i - 1][j], DP[i - 1][j + 1]) + matrix[i - 1][j];
                } else if (j == row - 1) {
                    DP[i][j] = Math.min(DP[i - 1][j], DP[i - 1][j - 1]) + matrix[i - 1][j];
                } else {
                    DP[i][j] = Math.min(Math.min(DP[i - 1][j], DP[i - 1][j + 1]), DP[i - 1][j - 1]) + matrix[i - 1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < row; k++) {
            min = Math.min(min, DP[row][k]);
        }
        return min;
    }
}
