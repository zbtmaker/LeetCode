package array;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 *
 * @author baitao zou
 * date 2020/05/10
 */
public class SetZeroes73 {

    public void setZeroes(int[][] matrix) {
        setZeroesByConstant(matrix);
    }

    /**
     * 通过一个行数组和列数组分别用于记录要置零的行和列，如果一行中有一个元素为零，那么行记录数组就需要把相应的行位置置为true，
     * 如果一列中有一个元素为零，那么列记录数组是需要把相应的位置设置为true。
     *
     * @param matrix
     */
    private void setZerosByOneDimension(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowIndex = new boolean[row];
        boolean[] colIndex = new boolean[col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowIndex[i] = true;
                    colIndex[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            if (rowIndex[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < col; j++) {
            if (colIndex[j]) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 采用常数空间复杂度完成，如果这一行有个元素为零，那么这一行都需要被置，那么我们就用每一行的第一个元素来记录是否需要被置零
     * 同理，我们用每一列的第一列来记录这一列是否需要被置零，简言之，我们用矩阵的第一行和第一列来记录。
     *
     * @param matrix
     */
    private void setZeroesByConstant(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //遍历第一行，遍历第一列
        boolean colFlag = false;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                colFlag = true;
                break;
            }
        }
        boolean rowFlag = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //这里必须要从第一行开始，否则就会把第一行全部置零，这样就会影响其他的列；
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        //这里必须要从第二列开始，否则就会把第一列所有元素全部置零，这样就会影响其他行
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        } else {
            if (colFlag) {
                Arrays.fill(matrix[0], 0);
            }
            if (rowFlag) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
