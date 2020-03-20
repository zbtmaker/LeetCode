package graph;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author baitao zou
 * date 2020/03/06
 */
public class FindRedundantDirectedConnection685Test {

    private FindRedundantDirectedConnection685 directed = new FindRedundantDirectedConnection685();

    @Test
    public void test1() {
        int[] result = directed.findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        Assert.assertArrayEquals(result, new int[]{2, 3});
    }

    @Test
    public void test2() {
        int[] result = directed.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}});
        Assert.assertArrayEquals(result, new int[]{4, 1});
    }

    @Test
    public void test3() {
        int[] result = directed.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}});
        Assert.assertArrayEquals(result, new int[]{4, 1});
    }
}
