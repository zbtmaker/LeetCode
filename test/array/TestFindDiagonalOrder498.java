package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/02
 */
public class TestFindDiagonalOrder498 extends TestCase {
    private FindDiagonalOrder498 find = new FindDiagonalOrder498();

    public void test1() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9});
    }

    public void test2() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1, 2, 4, 5, 3, 6});
    }

    public void test3() {
        int[][] matrix = new int[][]{
                {1, 2, 3}
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1, 2, 3});
    }


    public void test4() {
        int[][] matrix = new int[][]{
                {1}, {2}, {3}
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1, 2, 3});
    }

    public void test5() {
        int[][] matrix = new int[][]{
                {1}, {3}
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1, 3});
    }

    public void test6() {
        int[][] matrix = new int[][]{
                {1, 3}
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1, 3});
    }

    public void test7() {
        int[][] matrix = new int[][]{
                {1}
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1});
    }

    public void test8() {
        int[][] matrix = new int[][]{
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{});
    }

    public void test9() {
        int[][] matrix = new int[][]{
                {1, 2},
                {4, 5},
                {7, 8}
        };
        int[] arr = find.findDiagonalOrder(matrix);
        Assert.assertArrayEquals(arr, new int[]{1, 2, 4, 7, 5, 8});
    }
}
