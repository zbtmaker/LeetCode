package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class NthUglyNumber264Test {
    private NthUglyNumber264 ugly = new NthUglyNumber264();

    @Test
    public void test1() {
        int result = ugly.nthUglyNumber(10);
        Assert.assertEquals(result,12);
    }

    @Test
    public void test2() {
        int result = ugly.nthUglyNumber(1);
        Assert.assertEquals(result,1);
    }

    @Test
    public void test3() {
        int result = ugly.nthUglyNumber(2);
        Assert.assertEquals(result,2);
    }

    @Test
    public void test4() {
        int result = ugly.nthUglyNumber(3);
        Assert.assertEquals(result,3);
    }

    @Test
    public void test5() {
        int result = ugly.nthUglyNumber(4);
        Assert.assertEquals(result,4);
    }

    @Test
    public void test6() {
        int result = ugly.nthUglyNumber(5);
        Assert.assertEquals(result,5);
    }

    @Test
    public void test7() {
        int result = ugly.nthUglyNumber(7);
        Assert.assertEquals(result,8);
    }
}
