package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/23
 */
public class CanPlaceFlowers605Test {
    private CanPlaceFlowers605 flowers = new CanPlaceFlowers605();


    @Test
    public void test1() {
        Assert.assertEquals(flowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1), true);
    }

    @Test
    public void test2() {
        Assert.assertEquals(flowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2), false);
    }

    @Test
    public void test3() {
        Assert.assertEquals(flowers.canPlaceFlowers(new int[]{1, 1, 0, 0, 1}, 0), true);
    }

    @Test
    public void test4() {
        Assert.assertEquals(flowers.canPlaceFlowers(new int[]{1}, 0), true);
    }

    @Test
    public void test5() {
        Assert.assertEquals(flowers.canPlaceFlowers(new int[]{1, 1, 0, 0, 1, 0}, 0), true);
    }

    @Test
    public void test6() {
        Assert.assertEquals(flowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2), true);
    }

    @Test
    public void test7() {
        Assert.assertEquals(flowers.canPlaceFlowers(new int[]{ 0, 0, 1, 0, 0}, 0), true);
    }
}
