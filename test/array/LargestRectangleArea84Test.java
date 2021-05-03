package array;

import junit.framework.TestCase;
import org.junit.Assert;

public class LargestRectangleArea84Test extends TestCase {
    private LargestRectangleArea84 rectangleArea84 = new LargestRectangleArea84();

    /**
     * 测试用例1
     */
    public void test1() {
        int area = rectangleArea84.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        Assert.assertEquals(area, 10);
    }

    /**
     * 测试用例2
     */
    public void test2() {
        int area = rectangleArea84.largestRectangleArea(new int[]{1});
        Assert.assertEquals(area, 1);
    }

    public void test3() {
        int area = rectangleArea84.largestRectangleArea(new int[]{1, 0, 1});
        Assert.assertEquals(area, 1);
    }

    /**
     * 测试用例2
     */
    public void test4() {
        int area = rectangleArea84.largestRectangleArea(new int[]{1, 1, 1});
        Assert.assertEquals(area, 3);
    }
}
