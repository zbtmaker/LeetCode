package dp;

/**
 * Created by Administrator on 2019\3\19 0019.
 */
public class MaximalSquare221 {
    /**
     * 要找到最大的矩阵，对于每一个(i,j)，是否能够成为一个最大的矩阵，其实取决于(i-1, j-1)这个位置
     * 的正方形大小。如果这个(i, j)行连续的1的长度大于等于(i-1, j-1)的长度，那么(i,j)在(i-1, j-1)的
     * 基础上能够形成一个更大的数组，如果(i-1,j-1)位置为0, 那么(i,j)位置能够组成的最大正方形为自身0.
     * a、如果(i-1, j-1) = 0, 那么(i,j)是否可以组成矩形看(i,j)位置的值
     * b、如果(i-1, j-1) != 0, 那么(i,j)能够组成一个更大的矩形，取决于(i,j)的行和列连续的1的最大值是
     * 否大于(i-1, j-1)正方形的边长
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // 统计每一行连续1的个数
        int[][] rowMax = countRow(matrix, row, col);

        // 统计每一列的连续1的个数
        int[][] colMax = countCol(matrix, row, col);
        int max = 0;
        int[][] rec = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    rec[i][j] = matrix[i][j] - '0';
                    max = Math.max(rec[i][j], max);
                } else {
                    if (matrix[i][j] != '0') {
                        if (rec[i - 1][j - 1] == 0) {
                            rec[i][j] = 1;
                        } else {
                            rec[i][j] = Math.min(Math.min(rowMax[i][j] - 1, rec[i - 1][j - 1]), colMax[i][j] - 1) + 1;
                        }
                        max = Math.max(max, rec[i][j] * rec[i][j]);
                    }
                }
            }

        }
        return max;
    }

    private int[][] countRow(char[][] matrix, int row, int col) {
        int[][] rowMax = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    rowMax[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] != '0') {
                        rowMax[i][j] = rowMax[i][j - 1] + 1;
                    }
                }
            }
        }
        return rowMax;
    }

    private int[][] countCol(char[][] matrix, int row, int col) {
        int[][] colMax = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    colMax[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] != '0') {
                        colMax[i][j] = colMax[i - 1][j] + 1;
                    }
                }
            }
        }
        return colMax;
    }
}
