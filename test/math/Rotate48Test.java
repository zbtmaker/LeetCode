package math;

import junit.framework.TestCase;

/**
 * @author baitao zou
 * date 2020/09/23
 */
public class Rotate48Test extends TestCase {

    private Rotate48 rotate = new Rotate48();

    public void test1() {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        rotate.rotate(matrix);
        print(matrix);
    }

    public void test2() {
        int[][] matrix = new int[][]{{1}};
        rotate.rotate(matrix);
        print(matrix);
    }

    public void test3() {
        int[][] matrix = new int[][]{};
        rotate.rotate(matrix);
        print(matrix);
    }

    public void test4() {
        int[][] matrix = new int[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 9}};
        rotate.rotate(matrix);
        print(matrix);
    }


    private void print(int[][] matrix) {
        int row = matrix.length;
        for (int[] ints : matrix) {
            for (int j = 0; j < row; j++) {
                System.out.print(ints[j] + ",");
            }
            System.out.println();
        }
    }
}
