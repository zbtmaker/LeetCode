package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/02/17
 */
public class KnightProbability688 {

    private final int[][] directionArr = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        return dfsWithMemorization(n, k, row, column, new HashMap<>()) / Math.pow(8, k);
        /*return dynamicProgrammingII(n, k, row, column) / Math.pow(8, k);*/
    }

    /**
     * 这里最好理解的其实是DFS遍历，给定一个起始点，经过K步之后仍旧在棋盘中，那么就是要找到从
     * (row, col)经过K步到n * n 内任意一点(i,j)的路径方式。这个题目和62题有点不同，第62题
     * 是从(0, 0)到(m, n)路径总数。这个题目是从(row, col)经过K步到(i,j)的路径数。
     * 用DFS，每经过一个节点，K就会自减，如果K减为0，且此时仍留在棋盘上，那么这条路径就是一条
     * 有效路径。
     *
     * @param n
     * @param k
     * @param row
     * @param col
     * @return
     */
    private double dfs(int n, int k, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        int count = 0;
        for (int[] direction : directionArr) {
            count += dfs(n, k - 1, row + direction[0], col + direction[1]);
        }
        return count;
    }

    /**
     * 用DFS，每经过一个节点，K就会自减，如果K减为0，且此时仍留在棋盘上，那么这条路径就是一条
     * 有效路径。因为中间会有重复计算，所以就需要使用数据结构将中间的计算结果存储起来。
     *
     * @param n
     * @param k
     * @param row
     * @param col
     * @param memorization
     * @return
     */
    private double dfsWithMemorization(int n, int k, int row, int col, Map<String, Double> memorization) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        String key = generateKey(k, row, col);
        Double result = memorization.get(key);
        if (result != null) {
            return result;
        }
        result = 0.0;
        for (int[] direction : directionArr) {
            result += dfsWithMemorization(n, k - 1, row + direction[0], col + direction[1], memorization);
        }
        memorization.put(key, result);
        return result;
    }

    private String generateKey(int k, int row, int col) {
        return k + "-" + row + "-" + col;
    }

    private double dynamicProgramming(int n, int k, int row, int col) {
        double[][][] dp = new double[k + 1][n][n];
        dp[0][col][row] = 1;
        for (int step = 1; step <= k; step++) {
            for (int rowIndex = 0; rowIndex < n; rowIndex++) {
                for (int colIndex = 0; colIndex < n; colIndex++) {
                    double count = 0;
                    for (int[] direction : directionArr) {
                        int x = rowIndex + direction[0], y = colIndex + direction[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            count += dp[step - 1][x][y];
                        }
                    }
                    dp[step][rowIndex][colIndex] = count;
                }
            }
        }
        double result = 0;
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < n; colIndex++) {
                result += dp[k][rowIndex][colIndex];
            }
        }
        return result;
    }

    private double dynamicProgrammingII(int n, int k, int row, int col) {
        double[][] lastStep = new double[n][n];
        lastStep[row][col] = 1;
        for (int step = 1; step <= k; step++) {
            double[][] curStep = new double[n][n];
            for (int rowIndex = 0; rowIndex < n; rowIndex++) {
                for (int colIndex = 0; colIndex < n; colIndex++) {
                    double count = 0;
                    for (int[] direction : directionArr) {
                        int x = rowIndex + direction[0], y = colIndex + direction[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            count += lastStep[x][y];
                        }
                    }
                    curStep[rowIndex][colIndex] = count;
                }
            }
            lastStep = curStep;
        }
        double result = 0;
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < n; colIndex++) {
                result += lastStep[rowIndex][colIndex];
            }
        }
        return result;
    }

}
