package unionfind;

import java.util.Arrays;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * 链接：https://leetcode-cn.com/problems/count-servers-that-communicate
 *
 * @author baitao zou
 * date 2020/03/09
 */
public class CountServers1267 {

    /**
     * 这里使用计数的方式统计每一行和每一列的服务器的数量，统计完以后，如果grid[i][j] == 1且
     * 行或者列的服务器数量大于1的话，该服务器的是联通的
     *
     * @param grid
     * @return
     */
    public int countServers(int[][] grid) {
        if (grid == null || grid.length <= 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] rowArr = new int[row];
        int[] colArr = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rowArr[i] += 1;
                    colArr[j] += 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && (rowArr[i] > 1 || colArr[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
