package tree;

import array.TriangleNumber611;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/04
 */
public class TriangleNumber611Test {
    private TriangleNumber611 triangle = new TriangleNumber611();

    @Test
    public void test1() {
        int num = triangle.triangleNumber(new int[]{3, 5, 8, 9, 12});
        Assert.assertEquals(num, 5);
    }

    @Test
    public void test2() {
        int index = triangle.triangleNumber(new int[]{1, 2, 3});
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test3() {
        int index = triangle.triangleNumber(new int[]{3, 5});
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test4() {
        int index = triangle.triangleNumber(null);
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test5() {
        int index = triangle.triangleNumber(new int[]{1, 2, 3, 4, 5, 6});
        Assert.assertEquals(index, 7);
    }

    @Test
    public void test6() {
        int result = triangle.triangleNumber(new int[]{0, 0, 0});
        Assert.assertEquals(result,0);
    }
}
