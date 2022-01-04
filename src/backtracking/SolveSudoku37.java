package backtracking;

/**
 * @author zoubaitao
 * date 2022/01/03
 */
public class SolveSudoku37 {

    private final static char DOT = '.';

    public void solveSudoku(char[][] board) {
        int[][] rowSet = new int[9][9];
        int[][] colSet = new int[9][9];
        int[][][] gridSet = new int[3][3][9];
        fillSet(board, rowSet, colSet, gridSet);
        recur(board, rowSet, colSet, gridSet, 0, 0);
    }

    /**
     * 采用回溯的方式，每一个'.'都是一个回溯节点而每一个节点可选项为1、2、3、4、5、6、7、8、9，如果后面有节点
     * 不满足条件，就需要对前一个步骤恢复现场，然后对下一个选项值判断。
     *
     * @param board   表格
     * @param rowSet  每一行数字集合
     * @param colSet  每一列数字集合
     * @param gridSet 每一个九宫格数字集合
     * @param i       行索引
     * @param j       列索引
     * @return true-当前路径合法，false-当前路径不合法
     */
    private boolean recur(char[][] board, int[][] rowSet, int[][] colSet,
                          int[][][] gridSet, int i, int j) {
        if (i >= board.length) {
            return true;
        }
        if (board[i][j] != DOT) {
            if (j + 1 >= board[0].length) {
                return recur(board, rowSet, colSet, gridSet, i + 1, 0);
            } else {
                return recur(board, rowSet, colSet, gridSet, i, j + 1);
            }
        }
        boolean flag = false;
        for (int k = 1; k <= 9; k++) {
            if (rowSet[i][k - 1] != k &&
                    colSet[j][k - 1] != k &&
                    gridSet[i / 3][j / 3][k - 1] != k) {
                // 设置现场
                rowSet[i][k - 1] = k;
                colSet[j][k - 1] = k;
                gridSet[i / 3][j / 3][k - 1] = k;
                board[i][j] = (char) (k + '0');
                // 下一个递归方向
                if (j + 1 >= board[0].length) {
                    flag = recur(board, rowSet, colSet, gridSet, i + 1, 0);
                } else {
                    flag = recur(board, rowSet, colSet, gridSet, i, j + 1);
                }
                // 恢复现场
                if (!flag) {
                    rowSet[i][k - 1] = 0;
                    colSet[j][k - 1] = 0;
                    gridSet[i / 3][j / 3][k - 1] = 0;
                    board[i][j] = DOT;
                }
            }
        }
        return flag;
    }

    public void fillSet(char[][] board,
                        int[][] rowSet,
                        int[][] colSet,
                        int[][][] gridSet) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int value = ch - '0';
                    int index = value - 1;
                    rowSet[i][index] = value;
                    colSet[j][index] = value;
                    gridSet[i / 3][j / 3][index] = value;
                }
            }
        }

    }
}
