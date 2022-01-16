package array;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class SearchMatrix74 {

    /**
     * 只要是涉及到有序数组的查找，那么就是使用二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int col = matrix[0].length;

        int left = 0;
        int right = (matrix.length * col) -1;

        while(left <= right){
            int middle = (left + right)>>1;
            int tmpRow = middle/matrix[0].length;
            int tmpCol = middle%col;
            if(matrix[tmpRow][tmpCol] < target){
                left = middle + 1;
            }else if(matrix[tmpRow][tmpCol] > target){
                right = middle - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
