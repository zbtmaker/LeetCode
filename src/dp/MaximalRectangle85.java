package dp;

import org.junit.Test;

/**
 * Created by Administrator on 2019\3\19 0019.
 */
public class MaximalRectangle85 {

    /**
     * 参考官方解法：记录每一行的连续为一的个数，之前的算法有一个错误的认为是对Dynamic Programming问题的错误认识。
     * 根据官方的题解，我们记录每一行连续出现'1'的位数。record[i][j] = (matrix[i][j] - '1')*(record[i][j-1] + 1)
     * 那么i,j位置的最大矩形就是max{min(record[k][j],record[i][j]}) * (i - k + 1), min(record([i][j],record[k][j],record[k-1][j])*(i - k +2) ....},k = i,i-1,...0
     *
     * @param matrix 矩形表示法
     * @return 矩形的最大面积
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int area = 0;
        int[][] record = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == '1') {
                        record[i][j] = 1;
                        area = 1;
                    }
                    continue;
                }
                if (i == 0) {
                    if (matrix[i][j] == '1') {
                        record[i][j] = record[i][j - 1] + 1;
                        area = Math.max(record[i][j], area);
                    }
                } else if (j == 0) {
                    if (matrix[i][j] == '1') {
                        record[i][j] = 1;
                        int tmpArea = 1;
                        for (int k = i - 1; k > -1; k--) {
                            if (record[k][j] == 0) {
                                break;
                            }
                            tmpArea++;
                        }
                        area = Math.max(tmpArea, area);
                    }
                } else {
                    if (matrix[i][j] == '1') {
                        record[i][j] = record[i][j - 1] + 1;
                        int minCol = record[i][j];
                        int tmpArea = minCol;
                        area = Math.max(tmpArea, area);
                        for (int k = i - 1; k > -1; k--) {
                            if (record[k][j] == 0) {
                                break;
                            }
                            minCol = Math.min(record[k][j], minCol);
                            tmpArea = minCol * (i - k + 1);
                            area = Math.max(area, tmpArea);
                        }
                    }
                }
            }
        }
        return area;
    }
}
