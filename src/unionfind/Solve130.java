package unionfind;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/03/16
 */
public class Solve130 {

    private static final char X = 'X';

    private static final char O = 'O';

    /**
     * 解决这个题的要领就是将最外围的"O"与一个点进行关联，如果我们使用一个额外的节点来关联这个所有的"O"节点。
     * 然后对二维数组中的"O"进行union操作。最后如果一个节点的root == pivot，就证明这个节点和外围的节点"O"连接了。
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        int len = row * col;
        int[] id = initId(len + 1);
        int[] size = new int[len + 1];
        Arrays.fill(size, 1);
        //第一行、最后一行
        for (int m = 0; m < col; m++) {
            if (board[0][m] == O) {
                union(m, len, id, size);
            }
            if (board[row - 1][m] == O) {
                union((row - 1) * col + m, len, id, size);
            }

        }
        //第一列、最后一列
        for (int n = 0; n < row; n++) {
            if (board[n][0] == O) {
                union(n * col, len, id, size);
            }

            if (board[n][col - 1] == O) {
                union(n * col + (col - 1), len, id, size);
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == X) {
                    continue;
                }
                if (board[i][j - 1] == board[i][j]) {
                    union(i * col + j - 1, i * col + j, id, size);
                }
                if (board[i - 1][j] == board[i][j]) {
                    union((i - 1) * col + j, i * col + j, id, size);
                }
            }
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == O && root(i * col + j, id) != len) {
                    board[i][j] = X;
                }
            }
        }
    }


    /**
     * @param i
     * @param id
     * @return
     */
    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * @param p    p节点
     * @param q    节点
     * @param id   节点的父节点集合
     * @param size 父节点的高度
     */
    private void union(int p, int q, int[] id, int[] size) {
        int pid = root(p, id);
        int qid = root(q, id);
        if (pid == qid) {
            return;
        }
        if (pid == size.length - 1 || size[pid] > size[qid]) {
            id[qid] = pid;
            size[pid] += size[qid];
        } else {
            id[pid] = qid;
            size[qid] += pid;
        }
    }

    /**
     * 初始化父节点数组
     *
     * @param len 二维数组行
     * @return 父节点数组
     */
    private int[] initId(int len) {
        int[] id = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
        return id;
    }
}
