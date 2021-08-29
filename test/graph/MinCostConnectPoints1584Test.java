package graph;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2021/08/29
 */
public class MinCostConnectPoints1584Test extends TestCase {
    private final MinCostConnectPoints1584 min = new MinCostConnectPoints1584();

    public void test1() {
        int result = min.minCostConnectPoints(new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        });
        Assert.assertEquals(result, 20);
    }

    public void test2() {
        int result = min.minCostConnectPoints(new int[][]{
                {3, 12}, {-2, 5}, {-4, 1}
        });
        Assert.assertEquals(result, 18);
    }

    public void test3() {
        int result = min.minCostConnectPoints(new int[][]{
                {0, 0}, {1, 1}, {1, 0}, {-1, 1}
        });
        Assert.assertEquals(result, 4);
    }

    public void test4() {
        int result = min.minCostConnectPoints(new int[][]{
                {-1000000, -1000000}, {1000000, 1000000}
        });
        Assert.assertEquals(result, 4000000);
    }
}
