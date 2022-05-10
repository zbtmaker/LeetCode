package graph;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/16
 */
public class CheckWays1719Test extends TestCase {
    private final CheckWays1719 ways = new CheckWays1719();

    public void test1() {
        int result = ways.checkWays(new int[][]{
                {1, 2},
                {2, 3}
        });
        Assert.assertEquals(result, 1);
    }

    public void test2() {
        int result = ways.checkWays(new int[][]{
                {1, 2}, {2, 3}, {1, 3}
        });
        Assert.assertEquals(result, 2);
    }

    public void test3() {
        int result = ways.checkWays(new int[][]{
                {1, 2}, {2, 3}, {2, 4}, {1, 5},
        });
        Assert.assertEquals(result, 0);
    }

    public void test4() {
        int result = ways.checkWays(new int[][]{
                {1, 5}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}
        });
        Assert.assertEquals(result, 2);
    }
}
