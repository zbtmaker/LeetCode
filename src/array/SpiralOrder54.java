package array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\7 0007.
 */
public class SpiralOrder54 {

    /**
     * 此题需要考虑四种情况：
     * 1、如何进行上面一行、右侧一列、下面一行、左侧一列、进行遍历
     * 2、什么时候结束遍历
     * 3、如果解决一行、一列的情况、只有一个元素的特殊问题
     * <p>
     * 其中有些难点就是如何确定退出循环、只有一行、只有一列的情况该如何处理。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        //衡坐标
        int x = 0;
        //纵坐标
        int y = 0;
        while (x <= col && y <= row) {
            //上面一行，此时横坐标变化，纵坐标不变
            for (int i = x; i <= col; i++) {
                list.add(matrix[x][i]);
            }
            //右侧一列，此时纵坐标变化，横坐标不变
            for (int j = y + 1; j < row; j++) {
                list.add(matrix[j][col]);
            }
            //下面一行，此时横坐标变化，纵坐标不变
            if (row > x) {
                for (int k = col; k >= x; k--) {
                    list.add(matrix[row][k]);
                }
            }

            //左侧一列，此时纵坐标变化，横坐标不变
            if (row > x && col > y) {
                for (int m = row  - 1; m > y; m--) {
                    list.add(matrix[m][x]);
                }
            }
            x++;
            y++;
            row--;
            col--;
        }
        return list;
    }
}
