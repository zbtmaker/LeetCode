package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/16
 */
public class MaxArea11Test {
    private MaxArea11 area = new MaxArea11();

    @Test
    public void test1() {
        int max = area.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assert.assertEquals(max, 49);
    }

    @Test
    public void test2() {
        int max = area.maxArea(new int[]{1, 6, 2, 8, 5, 4, 9, 3, 7});
        Assert.assertEquals(max, 42);
    }
}
