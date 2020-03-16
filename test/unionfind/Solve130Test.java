package unionfind;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/03/16
 */
public class Solve130Test {

    private Solve130 solve = new Solve130();

    @Test
    public void test1() {
        char[][] boards = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve.solve(boards);
        for (char[] board : boards) {
            System.out.println(Arrays.toString(board));
        }
    }


    @Test
    public void test2() {
        char[][] boards = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'O'}};
        solve.solve(boards);
        for (char[] board : boards) {
            System.out.println(Arrays.toString(board));
        }
    }

    @Test
    public void test3() {
        char[][] boards = new char[][]{{'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        solve.solve(boards);
        for (char[] board : boards) {
            System.out.println(Arrays.toString(board));
        }
    }

    @Test
    public void test4() {
        char[][] boards = new char[][]{};
        solve.solve(boards);
        for (char[] board : boards) {
            System.out.println(Arrays.toString(board));
        }
    }

    @Test
    public void test5() {
        char[][] boards = new char[][]{{'X', 'O', 'O', 'X'}};
        solve.solve(boards);
        for (char[] board : boards) {
            System.out.println(Arrays.toString(board));
        }
    }
}
