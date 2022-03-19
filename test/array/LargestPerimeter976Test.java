package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/19
 */
public class LargestPerimeter976Test extends TestCase {

    private final LargestPerimeter976 largest = new LargestPerimeter976();

    public void test1() {
        int max = largest.largestPerimeter(new int[]{2, 1, 2});
        Assert.assertEquals(max, 5);
    }

    public void test2() {
        int max = largest.largestPerimeter(new int[]{1, 1, 2});
        Assert.assertEquals(max, 0);
    }
}
