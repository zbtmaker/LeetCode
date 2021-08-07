package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/21
 */
public class TestShortestSubarray862 extends TestCase {
    private ShortestSubarray862 shortest = new ShortestSubarray862();

    public void test1() {
        int min = shortest.shortestSubarray(new int[]{1, 2, 3}, 2);
        Assert.assertEquals(min, 1);
    }

    public void test2() {
        int min = shortest.shortestSubarray(new int[]{17, 85, 93, -45, -21}, 150);
        Assert.assertEquals(min, 2);
    }

    public void test3() {
        int min = shortest.shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167);
        Assert.assertEquals(min, 3);
    }

    public void test4() {
        int min = shortest.shortestSubarray(new int[]{84, -1, 84, 1, 1, 1, 1, 1, 82}, 167);
        Assert.assertEquals(min, 3);
    }

    public void test5() {
        int min = shortest.shortestSubarray(new int[]{75, -32, 50, 32, 97}, 129);
        Assert.assertEquals(min, 2);
    }
}
