package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/11
 */
public class Divide29Test {

    private Divide29 divide = new Divide29();

    @Test
    public void test1() {
        int result = divide.divide(10, 3);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void test2() {
        int result = divide.divide(10, -3);
        Assert.assertEquals(result, -3);
    }

    @Test
    public void test3() {
        int result = divide.divide(3, -3);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void test4() {
        int result = divide.divide(2, -3);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test5() {
        int result = divide.divide(-2147483648, -1);
        Assert.assertEquals(result, 2147483647);
    }

    @Test
    public void test6() {
        int result = divide.divide(-2147483648, 1);
        Assert.assertEquals(result, -2147483648);
    }

    @Test
    public void test7() {
        int result = divide.divide(2147483647, 1);
        Assert.assertEquals(result, 2147483647);
    }
}
