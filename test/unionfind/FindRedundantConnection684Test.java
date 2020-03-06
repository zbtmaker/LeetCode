package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/06
 */
public class FindRedundantConnection684Test {
    private FindRedundantConnection684 find = new FindRedundantConnection684();

    @Test
    public void test1() {
        int[] result = find.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        Assert.assertArrayEquals(result, new int[]{2, 3});
    }

    @Test
    public void test2() {
        int[] result = find.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});
        Assert.assertArrayEquals(result, new int[]{1, 4});
    }

    @Test
    public void test3() {
        int[] result = find.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {1, 3}});
        Assert.assertArrayEquals(result, new int[]{1, 3});
    }

    @Test
    public void test4() {
        int[] result = find.findRedundantConnection(new int[][]{{2, 3}, {1, 3}, {1, 2}});
        Assert.assertArrayEquals(result, new int[]{1, 2});
    }

    @Test
    public void test5() {
        int[] result = find.findRedundantConnection(new int[][]{{2, 3}, {3, 4}, {1, 4}, {1, 5}, {1, 2}});
        Assert.assertArrayEquals(result, new int[]{1, 2});
    }

    @Test
    public void test6() {
        int[] result = find.findRedundantConnection(new int[][]{{2, 3}, {1, 4}, {3, 4}, {1, 2}, {1, 5}});
        Assert.assertArrayEquals(result, new int[]{1, 2});
    }
}
