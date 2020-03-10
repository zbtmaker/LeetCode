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

    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rowMarked = new int[row];
        int[] colMarked = new int[col];
        int[] size = new int[row * col];
        Arrays.fill(size, 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rowMarked[i] = rowMarked[i] + 1;
                    colMarked[j] = rowMarked[j] + 1;
                }
            }
        }
        int sum = 0;
        return sum;
    }
}
