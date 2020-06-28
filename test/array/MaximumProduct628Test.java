package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/28
 */
public class MaximumProduct628Test extends TestCase {

    private MaximumProduct628 product = new MaximumProduct628();

    public void test1() {
        int max = product.maximumProduct(new int[]{1, 2, 3});
        Assert.assertEquals(max, 6);
    }

    public void test2() {
        int max = product.maximumProduct(new int[]{1, 2, 3, 4});
        Assert.assertEquals(max, 24);
    }

    public void test3() {
        int max = product.maximumProduct(new int[]{-5, -6, -1, 1});
        Assert.assertEquals(max, 30);
    }

    public void test4() {
        int max = product.maximumProduct(new int[]{-5, -6, -1});
        Assert.assertEquals(max, -30);
    }
}
