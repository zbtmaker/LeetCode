package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/13
 */
public class FindMin153Test {
    private FindMin153 min = new FindMin153();

    @Test
    public void test1() {
        int result = min.findMin(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test2() {
        int result = min.findMin(new int[]{7, 0, 1, 2, 3, 4, 5, 6});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test3() {
        int result = min.findMin(new int[]{0, 1, 2, 3, 4, 5, 6});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test4() {
        int result = min.findMin(new int[]{1, 2, 3, 4, 5, 6, 0});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test5() {
        int result = min.findMin(new int[]{0});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test6() {
        int result = min.findMin(new int[]{4, 5, 1, 2, 3});
        Assert.assertEquals(result, 1);
    }
}
