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
        return numIslandsByDFS(grid);
    }

    /**
     * 采用Union Find方式
     *
     * @param grid 二维数组
     * @return 岛数量
     */
    private int numIslandsByUnionFind(char[][] grid) {
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

    /**
     * @param row 二维数组行
     * @param col 二维数组列
     * @return 初始化根节点
     */
    private int[] initId(int row, int col) {
        int len = row * col;
        int[] id = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
        return id;
    }

    /**
     * 统计矩阵中岛屿数量
     *
     * @param grid 二维矩阵
     * @return 字符 '1' 数量
     */
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

    /**
     * @param grid 二维矩阵
     * @return 岛数量
     */
    private int numIslandsByDFS(char[][] grid) {
        int row = grid.length, col = grid[0].length;

        int[] islands = new int[1];
        islands[0] = countLand(grid);

        boolean[] flag = new boolean[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(grid, i, j, flag, islands);
            }
        }
        return islands[0];
    }

    /**
     * @param grid    二维矩阵
     * @param i       行
     * @param j       列
     * @param flag    标识是否发送过
     * @param islands 孤立岛屿数量
     * @return 是否有节点相连
     */
    private boolean dfs(char[][] grid, int i, int j, boolean[] flag, int[] islands) {
        int row = grid.length, col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }
        if (grid[i][j] == '0') {
            return false;
        }

        if (flag[i * col + j]) {
            return false;
        }

        flag[i * col + j] = true;

        if (dfs(grid, i - 1, j, flag, islands)) {
            islands[0] -= 1;
        }
        if (dfs(grid, i + 1, j, flag, islands)) {
            islands[0] -= 1;
        }
        if (dfs(grid, i, j - 1, flag, islands)) {
            islands[0] -= 1;
        }
        if (dfs(grid, i, j + 1, flag, islands)) {
            islands[0] -= 1;
        }
        return true;
    }
}
