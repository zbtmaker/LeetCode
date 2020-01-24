package array;

import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/24
 */
public class Merge56Test {
    private Merge56 merge = new Merge56();

    @Test
    public void test1() {
        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] result = merge.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println("{" + result[i][0] + "," + result[i][1] + "}");
        }
    }

    @Test
    public void test2() {
        int[][] intervals = new int[][]{{1, 3}, {4, 17}, {2, 6}, {15, 18}};
        int[][] result = merge.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println("{" + result[i][0] + "," + result[i][1] + "}");
        }
    }

    @Test
    public void test3() {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {1, 2}, {15, 18}};
        int[][] result = merge.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println("{" + result[i][0] + "," + result[i][1] + "}");
        }
    }

    @Test
    public void test4(){
        int[][] intervals = new int[][]{{1, 3}, {3, 6}};
        int[][] result = merge.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println("{" + result[i][0] + "," + result[i][1] + "}");
        }
    }
}
