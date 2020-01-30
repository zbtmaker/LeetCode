package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/30
 */
public class Insert57Test {

    private Insert57 insert = new Insert57();

    @Test
    public void test1() {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{1, 5}, {6, 9}});
    }

    @Test
    public void test2() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{1, 2}, {3, 10}, {12, 16}});
    }

    @Test
    public void test3() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{17, 19};
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}, {17, 19}});
    }

    @Test
    public void test4() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{-2, -1};
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{-2, -1}, {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}});
    }

    @Test
    public void test5() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {17, 19}};
        int[] newInterval = new int[]{12, 16};
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}, {17, 19}});
    }

    @Test
    public void test6() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {17, 19}};
        int[] newInterval = new int[]{12, 16};
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}, {17, 19}});
    }

    @Test
    public void test7() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {17, 19}};
        int[] newInterval = new int[0];
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {17, 19}});
    }

    @Test
    public void test8() {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{0,3};
        int[][] result = insert.insert(intervals, newInterval);
        Assert.assertArrayEquals(result, new int[][]{{0, 5}});
    }
}
