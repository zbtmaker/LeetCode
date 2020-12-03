package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\3 0003.
 */
public class SolveNQueens51 {
    /**
     * @param n 棋盘维数
     * @return 棋盘结果
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        recur(initBoard(n), 0, n, result);
        return result;
    }

    /**
     * @param board  char棋盘
     * @param row    行
     * @param n      棋盘维数
     * @param result 棋盘结果
     */
    private void recur(char[][] board, int row, int n, List<List<String>> result) {
        if (row == n) {
            result.add(constructBoard(board, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isLocation(board, row, i, n)) {
                board[row][i] = 'Q';
                recur(board, row + 1, n, result);
                board[row][i] = '.';
            }

        }
    }

    /**
     * 是否和已放置的Queen是否冲突
     *
     * @param board 棋盘
     * @param i     当前行
     * @param j     列
     * @param n     棋盘维数
     * @return true-不冲突 ｜ false-冲突
     */
    private boolean isLocation(char[][] board, int i, int j, int n) {
        for (int m = i - 1; m >= 0; m--) {
            if (board[m][j] == 'Q') {
                return false;
            }
        }
        for (int m = i - 1, k = j - 1; m >= 0 && k >= 0; m--, k--) {
            if (board[m][k] == 'Q') {
                return false;
            }
        }
        for (int m = i - 1, k = j + 1; m >= 0 && k < n; m--, k++) {
            if (board[m][k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 将棋盘char字符串转换为String
     *
     * @param board char类型的棋盘
     * @param n     棋盘维数
     * @return 字符串棋盘
     */
    private List<String> constructBoard(char[][] board, int n) {
        List<String> boards = new ArrayList<>(n);
        StringBuilder sb;
        for (char[] row : board) {
            sb = new StringBuilder(n);
            sb.append(row);
            boards.add(sb.toString());
        }
        return boards;
    }

    /**
     * 棋盘初始化
     *
     * @param n 棋盘维数
     * @return 棋盘
     */
    private char[][] initBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }
}
