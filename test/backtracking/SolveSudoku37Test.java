package backtracking;

import junit.framework.TestCase;

/**
 * @author zoubaitao
 * date 2022/01/03
 */
public class SolveSudoku37Test extends TestCase {

    private final SolveSudoku37 sudoku = new SolveSudoku37();

    public void test1() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        sudoku.solveSudoku(board);
        print(board);
    }

    private void print(char[][] arr) {
        for (char[] chars : arr) {
            System.out.println(chars);
        }
    }
}
