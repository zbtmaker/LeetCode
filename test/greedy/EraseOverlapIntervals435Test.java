package greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/04
 */
public class EraseOverlapIntervals435Test {

    private EraseOverlapIntervals435 erase = new EraseOverlapIntervals435();

    @Test
    public void test1() {
        int num = erase.eraseOverlapIntervals(new int[][]{});
        Assert.assertEquals(num, 0);
    }

    @Test
    public void test2() {
        int num = erase.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        Assert.assertEquals(num, 1);
    }

    @Test
    public void test3() {
        int num = erase.eraseOverlapIntervals(new int[][]{{1, 3}, {4, 6}, {7, 9}, {2, 8}});
        Assert.assertEquals(num, 1);
    }
}
