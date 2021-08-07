package math;

/**
 * @author baitao zou
 * date 2020/09/23
 */
public class Rotate48 {
    public void rotate(int[][] matrix) {
        rotateI(matrix);
    }

    /**
     * 时间复杂度为O(N^2),只不过我们这里的执行的次数为2N^2，空间复杂度为O(N)
     *
     * @param matrix
     */
    private void rotateI(int[][] matrix) {
        int row = matrix.length;
        if (row <= 1) {
            return;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < i; j++) {
                swapSlant(matrix, i, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0, k = row - 1; j < k; j++, k--) {
                matrix[i][j] = matrix[i][j] ^ matrix[i][k];
                matrix[i][k] = matrix[i][j] ^ matrix[i][k];
                matrix[i][j] = matrix[i][j] ^ matrix[i][k];
            }
        }
    }

    /**
     * 对角线交换
     *
     * @param matrix 二维矩阵
     * @param i      行索引
     * @param j      列索引
     */
    private void swapSlant(int[][] matrix, int i, int j) {
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
        matrix[j][i] = matrix[i][j] ^ matrix[j][i];
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
    }

    /**
     * 水平位置交换
     *
     * @param matrix 二维矩阵
     * @param i      行索引
     * @param j      列左索引
     * @param k      列右索引
     */
    private void swapLevel(int[][] matrix, int i, int j, int k) {
        matrix[i][j] = matrix[i][j] ^ matrix[i][k];
        matrix[i][k] = matrix[i][j] ^ matrix[i][k];
        matrix[i][j] = matrix[i][j] ^ matrix[i][k];
    }
}
