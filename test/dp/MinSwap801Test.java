package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/16
 */
public class MinSwap801Test {

    private MinSwap801 minSwap = new MinSwap801();

    @Test
    public void test1() {
        int[] A = new int[]{1, 3, 5, 4};
        int[] B = new int[]{1, 2, 3, 7};
        int min = minSwap.minSwap(A, B);
        Assert.assertEquals(min, 1);
        Assert.assertArrayEquals(A, new int[]{1, 3, 5, 7});
        Assert.assertArrayEquals(B, new int[]{1, 2, 3, 4});
    }

    @Test
    public void test2() {

        int[] A = new int[]{0, 4, 4, 5, 9};
        int[] B = new int[]{0, 1, 6, 8, 10};
        int min = minSwap.minSwap(A, B);
        Assert.assertEquals(min, 1);
        Assert.assertArrayEquals(A, new int[]{0, 1, 4, 5, 9});
        Assert.assertArrayEquals(B, new int[]{0, 4, 6, 8, 10});
    }

    @Test
    public void test3() {
        int[] A = new int[]{2, 3, 2, 5, 6};
        int[] B = new int[]{0, 1, 4, 4, 5};
        int min = minSwap.minSwap(A, B);
        Assert.assertEquals(min, 2);
        Assert.assertArrayEquals(A, new int[]{2, 3, 4, 5, 6});
        Assert.assertArrayEquals(B, new int[]{0, 1, 2, 4, 5});
    }
}
