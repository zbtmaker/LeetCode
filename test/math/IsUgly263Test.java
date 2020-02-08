package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class IsUgly263Test {

    private IsUgly263 ugly = new IsUgly263();

    @Test
    public void test1() {
        boolean flag = ugly.isUgly(1);
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        boolean flag = ugly.isUgly( 2);
        Assert.assertTrue(flag);
    }

    @Test
    public void test3() {
        boolean flag = ugly.isUgly( 3);
        Assert.assertTrue(flag);
    }

    @Test
    public void test4() {
        boolean flag = ugly.isUgly( 4);
        Assert.assertTrue(flag);
    }


    @Test
    public void test5() {
        boolean flag = ugly.isUgly( 5);
        Assert.assertTrue(flag);
    }

    @Test
    public void test7() {
        boolean flag = ugly.isUgly( 19);
        Assert.assertFalse(flag);
    }

    @Test
    public void test8() {
        boolean flag = ugly.isUgly( Integer.MAX_VALUE);
        Assert.assertFalse(flag);
    }

    @Test
    public void test9() {
        boolean flag = ugly.isUgly(14);
        Assert.assertFalse(flag);
    }
}
