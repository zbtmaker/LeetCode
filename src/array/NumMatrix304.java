package array;

/**
 * @author Baitao Zou
 * date 2021/02/13
 */
public class NumMatrix304 {

    private int[][] sumMatrix;

    public NumMatrix304(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            sumMatrix = new int[0][0];
            return;
        }
        int col = matrix[0].length;
        sumMatrix = new int[row][col + 1];
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += matrix[i][j];
                sumMatrix[i][j + 1] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sumMatrix[i][col2 + 1] - sumMatrix[i][col1];
        }
        return sum;
    }
}
