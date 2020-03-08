package unionfind;

import java.util.*;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 算法4参考代码 https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/WeightedQuickUnionUF.java.html
 *
 * @author baitao zou
 * date 2020/03/08
 */
public class NumIslands200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] id = initId(row, col);
        int[] size = new int[row * col];
        int[] count = new int[1];
        count[0] = countLand(grid);
        Arrays.fill(size, 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 && j == 0) || grid[i][j] == '0') {
                    continue;
                }
                if (i == 0) {
                    if (grid[i][j - 1] == '1') {
                        union(i * col + j - 1, i * col + j, id, size, count);
                    }
                } else if (j == 0) {
                    if (grid[i - 1][j] == '1') {
                        union((i - 1) * col + j, i * col + j, id, size, count);
                    }
                } else {
                    if (grid[i - 1][j] == '1') {
                        union((i - 1) * col + j, i * col + j, id, size, count);
                    }
                    if (grid[i][j - 1] == '1') {
                        union(i * col + j - 1, i * col + j, id, size, count);
                    }
                }
            }
        }

        return count[0];
    }

    private int[] initId(int row, int col) {
        int len = row * col;
        int[] id = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
        return id;
    }

    private int countLand(char[][] grid) {
        int count = 0;
        for (char[] chs : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (chs[j] == '1') {
                    count++;
                }
            }
        }
        return count;
    }

    private int root(int i, int[] id) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q, int[] id, int[] size, int[] count) {
        int pid = root(p, id);
        int qid = root(q, id);
        if (pid == qid) {
            return;
        }
        if (size[pid] >= size[qid]) {
            id[qid] = pid;
            size[pid] += size[pid];
        } else {
            id[pid] = qid;
            size[qid] += size[pid];
        }
        count[0] = count[0] - 1;
    }
}
