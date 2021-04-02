package array;

/**
 * @author Baitao Zou
 * date 2021/02/25
 */
public class SearchMatrix240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int rowIndex = 0, colIndex = col - 1;
        while (rowIndex < row && colIndex >= 0) {
            if (matrix[rowIndex][colIndex] < target) {
                rowIndex++;
            } else if (matrix[rowIndex][colIndex] > target) {
                colIndex--;
            } else {
                return true;
            }
        }
        return false;
    }
}
