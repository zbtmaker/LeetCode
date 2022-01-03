package backtracking;

import java.util.Arrays;

/**
 * 是否是有效数独
 *
 * @author zoubaitao
 * date 2022/01/03
 */
public class IsValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        char[][] rowSet = new char[9][9];
        fill(rowSet);
        char[][] colSet = new char[9][9];
        fill(colSet);
        char[][][] gridSet = new char[3][3][9];
        fill(gridSet);
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (rowSet[i][ch - '0' - 1] == ch) {
                    return false;
                }
                if (colSet[j][ch - '0' - 1] == ch) {
                    return false;
                }
                if (gridSet[i / 3][j / 3][ch - '0' - 1] == ch) {
                    return false;
                }
                rowSet[i][ch - '0' - 1] = ch;
                colSet[j][ch - '0' - 1] = ch;
                gridSet[i / 3][j / 3][ch - '0' - 1] = ch;
            }
        }
        return true;

    }

    private void fill(char[][] arr) {
        for (char[] chars : arr) {
            Arrays.fill(chars, ' ');
        }
    }

    public void fill(char[][][] arr) {
        for (char[][] chars : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                Arrays.fill(chars[j], ' ');
            }
        }
    }
}
