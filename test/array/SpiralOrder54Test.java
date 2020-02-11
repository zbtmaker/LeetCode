package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author baitao zou
 * date 2020/02/11
 */
public class SpiralOrder54Test {

    private SpiralOrder54 spiral = new SpiralOrder54();

    /**
     * 1    2   3
     * 4    5   6
     * 7    8   9
     */
    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = spiral.spiralOrder(matrix);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5});
    }

    /**
     * 1    2   3   4
     * 5    6   7   8
     * 9    10  11  12
     */
    @Test
    public void test2() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> result = spiral.spiralOrder(matrix);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7});
    }

    /**
     * 1    2   3
     */
    @Test
    public void test3() {
        int[][] matrix = new int[][]{{1, 2, 3}};
        List<Integer> result = spiral.spiralOrder(matrix);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1, 2, 3});
    }

    /**
     * 1    2
     * 3    4
     */
    @Test
    public void test4() {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        List<Integer> result = spiral.spiralOrder(matrix);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1, 2, 4, 3});
    }

    /**
     * 1
     */
    @Test
    public void test5() {
        int[][] matrix = new int[][]{{1}};
        List<Integer> result = spiral.spiralOrder(matrix);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1});
    }

    /**
     * 1
     * 2
     * 3
     * 4
     */
    @Test
    public void test6() {
        int[][] matrix = new int[][]{{1}, {2}, {3}, {4}};
        List<Integer> result = spiral.spiralOrder(matrix);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1, 2, 3, 4});
    }

    /**
     * 1    2   3
     * 4    5   6
     * 7    8   9
     * 10   11  12
     */
    @Test
    public void test7() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> result = spiral.spiralOrder(matrix);
        result.forEach(System.out::println);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8});
    }

    @Test
    public void test8() {
        int[][] matrix = new int[][]{};
        List<Integer> result = spiral.spiralOrder(matrix);
        result.forEach(System.out::println);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{});
    }

    @Test
    public void test9() {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        List<Integer> result = spiral.spiralOrder(matrix);
        result.forEach(System.out::println);
        Assert.assertArrayEquals(result.stream().mapToInt(Integer::intValue).toArray(), new int[]{1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13});
    }
}
