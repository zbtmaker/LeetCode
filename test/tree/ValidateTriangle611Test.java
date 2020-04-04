package tree;

import array.ValidateTriangle611;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/04
 */
public class ValidateTriangle611Test {
    private ValidateTriangle611 triangle = new ValidateTriangle611();

    @Test
    public void test1() {
        int num = triangle.validateTriangle(new int[]{3, 5, 8, 9, 12});
        Assert.assertEquals(num, 5);
    }

    @Test
    public void test2() {
        int index = triangle.validateTriangle(new int[]{1, 2, 3});
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test3() {
        int index = triangle.validateTriangle(new int[]{3, 5});
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test4() {
        int index = triangle.validateTriangle(null);
        Assert.assertEquals(index, 0);
    }
}
