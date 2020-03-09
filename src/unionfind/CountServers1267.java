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
        int[] id = initId(row, col);
        int[] size = new int[row * col];
        Arrays.fill(size, 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 && j == 0) || grid[i][j] == 0) {
                    continue;
                }

                if (i == 0) {
                    if (grid[i][j - 1] == 1) {
                        union(i * col + j - 1, i * col + j, id, size);
                    }
                } else if (j == 0) {
                    if (grid[i - 1][j] == 1) {
                        union((i - 1) * col + j, i * col + j, id, size);
                    }
                } else {
                    if (grid[i - 1][j] == 1) {
                        union((i - 1) * col + j, i * col + j, id, size);
                    }
                    if (grid[i][j - 1] == 1) {
                        union(i * col + j - 1, i * col + j, id, size);
                    }
                }
            }
        }
        int sum = 0;
        for (int k = 0; k < row * col; k++) {
            if (k == id[k] && size[k] > 1) {
                sum += size[k];
            }
        }
        return sum;
    }

    private int[] initId(int row, int col) {
        int[] id = new int[row * col];
        for (int i = 0; i < row * col; i++) {
            id[i] = i;
        }
        return id;
    }

    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q, int[] id, int[] size) {
        int pid = root(p, id);
        int qid = root(q, id);
        if (pid == qid) {
            return;
        }
        if (size[pid] >= size[qid]) {
            id[qid] = pid;
            size[pid] += size[qid];
        } else {
            id[pid] = qid;
            size[qid] += size[pid];
        }
    }
}
