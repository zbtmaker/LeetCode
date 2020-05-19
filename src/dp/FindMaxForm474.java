package dp;

/**
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 *
 * @author baitao zou
 * date 2020/05/11
 */
public class FindMaxForm474 {

    private static final int dimension = 2;

    /**
     * 二维的背包问题，之前是一维背包问题。
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxFormByDynamicProgramming(strs, m, n);
    }


    /**
     * 回溯算法解决背包问题，超时
     *
     * @param strs
     * @param m    0的个数
     * @param n    1的个数
     * @return
     */
    private int findMaxFormByBacktracking(String[] strs, int m, int n) {
        int[] max = new int[dimension];
        int[] total = new int[]{m, n};
        recurFindMaxForm(parseStrs(strs), 0, total, max);
        return max[1];
    }


    /**
     * @param countArr
     * @param index
     * @param total
     * @param max
     */
    private void recurFindMaxForm(int[][] countArr, int index, int[] total, int[] max) {
        if (total[0] >= 0 && total[1] >= 0) {
            max[1] = Math.max(max[0], max[1]);
        } else {
            return;
        }
        for (int i = index; i < countArr.length; i++) {
            total[0] -= countArr[i][0];
            total[1] -= countArr[i][1];
            max[0]++;
            recurFindMaxForm(countArr, i + 1, total, max);
            total[0] += countArr[i][0];
            total[1] += countArr[i][1];
            max[0]--;
        }
    }

    private int recurFindMaxFormByTopDown(int[][] A, int m, int n, int k) {
        if (k == 0) {
            return 0;
        }
        if (m < A[k - 1][0] || n < A[k - 1][1]) {
            return recurFindMaxFormByTopDown(A, m, n, k - 1);
        }
        return Math.max(recurFindMaxFormByTopDown(A, m, n, k - 1), recurFindMaxFormByTopDown(A, m - A[k - 1][0], n - A[k - 1][1], k - 1) + 1);

    }

    /**
     * 动态规划
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    private int findMaxFormByDynamicProgramming(String[] strs, int m, int n) {
        return findMaxFormByBottomUpDynamicProgramming(strs, m, n);
    }

    /**
     * 自底向上+Memorization
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    private int findMaxFormByBottomUpDynamicProgramming(String[] strs, int m, int n) {
        int[][] A = parseStrs(strs);
        int len = strs.length;
        int[][][] F = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j == 0 && k == 0) {
                        continue;
                    }
                    if (j < A[i - 1][0] || k < A[i - 1][1]) {
                        F[i][j][k] = F[i - 1][j][k];
                    } else {
                        F[i][j][k] = Math.max(F[i - 1][j][k], F[i - 1][j - A[i - 1][0]][k - A[i - 1][1]] + 1);
                    }
                }
            }
        }
        return F[len][m][n];
    }

    /**
     * 自顶向下递归+Memorization
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    private int findMaxFormByTopDownDynamicProgramming(String[] strs, int m, int n) {
        int[][] A = parseStrs(strs);
        int len = strs.length;
        int[][][] F = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    F[i][j][k] = j == 0 && k == 0 ? 0 : -1;
                }
            }
        }
        return recurFindMaxFormByTopDowDynamicProgramming(A, m, n, len, F);

    }

    private int recurFindMaxFormByTopDowDynamicProgramming(int[][] A, int m, int n, int k, int[][][] F) {
        if (k == 0) {
            return 0;
        }
        if (F[k][m][n] >= 0) {
            return F[k][m][n];
        }
        if (m < A[k - 1][0] || n < A[k - 1][1]) {
            F[k - 1][m][n] = recurFindMaxFormByTopDowDynamicProgramming(A, m, n, k - 1, F);
            return F[k - 1][m][n];
        }
        F[k - 1][m][n] = recurFindMaxFormByTopDowDynamicProgramming(A, m, n, k - 1, F);
        F[k - 1][m - A[k - 1][0]][n - A[k - 1][1]] = recurFindMaxFormByTopDowDynamicProgramming(A, m - A[k - 1][0], n - A[k - 1][1], k - 1, F);
        F[k][m][n] = Math.max(F[k - 1][m][n], F[k - 1][m - A[k - 1][0]][n - A[k - 1][1]] + 1);
        return F[k][m][n];
    }

    /**
     * 由一维背包问题的动态规划思想解决二维背包问题，就像一个限制条件的背包问题一样，我们要解决大的背包那么我们就需要解决小的背包问题
     * 那么这里我们用一个二维的数组表示当我们要解决背包大小。其实在完成二维动态规划之前，先要好好思考一下一个限制条件的背包条件是如何由
     * 二维算法优化到一维的。
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    private int findMaxFormByTopDonwDP(String[] strs, int m, int n) {
        int[][] arr = parseStrs(strs);
        int[][] dp = new int[m + 1][n + 1];

        return 0;
    }

    private int[][] parseStrs(String[] strs) {
        int[][] countArr = new int[strs.length][dimension];
        for (int i = 0; i < strs.length; i++) {
            countArr[i] = parseStr(strs[i]);
        }
        return countArr;
    }

    private int[] parseStr(String str) {
        int[] zeroOneArr = new int[dimension];
        for (int i = 0; i < str.length(); i++) {
            zeroOneArr[str.charAt(i) - '0']++;
        }
        return zeroOneArr;
    }
}
