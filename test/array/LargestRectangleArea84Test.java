package array;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleArea84Test {
    private LargestRectangleArea84 rectangleArea84 = new LargestRectangleArea84();

    /**
     * 测试用例1
     */
    @Test
    public void test1() {
        int area = rectangleArea84.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        Assert.assertEquals(area, 10);
    }

    /**
     * 测试用例2
     */
    @Test
    public void test2() {
        int area = rectangleArea84.largestRectangleArea(new int[]{1});
        Assert.assertEquals(area, 1);
    }

    @Test
    public void test3() {
        int area = rectangleArea84.largestRectangleArea(new int[]{1, 0, 1});
        Assert.assertEquals(area, 1);
    }

    /**
     * 测试用例2
     */
    @Test
    public void test4() {
        int area = rectangleArea84.largestRectangleArea(new int[]{1,1,1});
        Assert.assertEquals(area, 3);
    }
}
