package array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Baitao Zou
 * date 2021/01/01
 */
public class FindDiagonalOrder498 {

    /**
     * 这里有一个很重要的点就是，我们用一个flag来表征是加还是减，通过规律可以
     * 得出结论，我们设置初始flag = 1,每执行一次循环就flag = -flag, 而我们用
     * i表示横坐标, j 表示纵坐标。这样我们通过规律可以得出i每次都是 i-= flag,
     * j += flag. 如果i < 0 || i >= row的情况下此时 i += flag, 如果j < 0 ||
     * j >= col的情况下，此时需要j -= flag.这个操作相当于是把错误值进行修正。
     * 还有一种特殊情况就是，一旦越过了对角线，那么就需要分情况讨论，也就是说，
     * 此时如果 i 在未修正操作之前我们用rowFlag = i , colFlag = j表示未修正之前
     * 的参数，那么这个时候如果rowFlag = row,而且 colFlag <0 的情况下，表示刚好在
     * 对角线的右下角，此时j 应该在修正之后再 +1，如果colFlag >= 0, 那么表示已经开始
     * 遍历右下半部分的数组元素了，此时应该j不会做修正操作，那么此时应该j +2.对于i的分析
     * 也是同理，只不过是右上半部分罢了,是对称的关系.
     * 还需要注意的一点就是，这个题目需要把所有的测试案例写出来才能够cover所有的case
     *
     * @param matrix 矩阵
     * @return 遍历结果
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length, col = matrix[0].length;

        int i = 0, j = 0, flag = 1, rowFlag = 0, colFlag = 0;
        while (!(i == row - 1 && j == col - 1)) {
            while (i >= 0 && i < row && j >= 0 && j < col) {
                result.add(matrix[i][j]);
                i -= flag;
                j += flag;
            }
            rowFlag = i;
            colFlag = j;
            if (i < 0 || i >= row) {
                i += flag;
            }
            if (j < 0 || j >= col) {
                j -= flag;
            }

            if (colFlag == col) {
                i = rowFlag < 0 ? i + 1 : i + 2;
            }
            if (rowFlag == row) {
                j = colFlag < 0 ? j + 1 : j + 2;
            }

            flag = -flag;
        }
        result.add(matrix[i][j]);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
