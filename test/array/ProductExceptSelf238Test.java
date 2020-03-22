package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/22
 */
public class ProductExceptSelf238Test {

    private ProductExceptSelf238 product = new ProductExceptSelf238();

    @Test
    public void test1() {

        int[] result = product.productExceptSelf(new int[]{1, 2, 3, 4});
        Assert.assertArrayEquals(result, new int[]{24, 12, 8, 6});
    }

    @Test
    public void test2() {
        int[] result = product.productExceptSelf(new int[]{2, 3});
        Assert.assertArrayEquals(result, new int[]{3, 2});
    }

    @Test
    public void test3() {
        int[] result = product.productExceptSelf(new int[]{2});
        Assert.assertArrayEquals(result, new int[]{1});
    }
}
