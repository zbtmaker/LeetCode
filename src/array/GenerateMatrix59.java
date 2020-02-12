package array;

/**
 * @author baitao zou
 * date 2020/02/11
 */
public class GenerateMatrix59 {
    /**
     * 这个题目可以参考SpiralOrder54。SpiralOrder54是螺旋打印，这个是螺旋生成，之前那个是不规则的矩形，
     * 这个题目是一个规则的正方形，因此不再需要x、y两个参数来控制，只需要一个参数x控制就可以了。同时也不需要
     * 行和列两个参数来控制，直接一个参数控制就好了
     *
     * @param n 数组的row*col
     * @return 生成的螺旋矩阵
     */
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int row = n - 1;
        int x = 0;
        int count = 1;
        while (x <= row) {
            //上面一行
            for (int i = x; i <= row; i++) {
                matrix[x][i] = count++;
            }
            //右侧一列
            for (int j = x + 1; j < row; j++) {
                matrix[j][row] = count++;
            }
            if (row > x) {
                //下面一行
                for (int k = row; k >= x; k--) {
                    matrix[row][k] = count++;
                }
                //右侧列
                for (int m = row - 1; m > x; m--) {
                    matrix[m][x] = count++;
                }
            }
            x++;
            row--;
        }
        return matrix;
    }
}
