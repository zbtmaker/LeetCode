package math;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class NthUglyNumber264Test extends TestCase {
    private final NthUglyNumber264 ugly = new NthUglyNumber264();

    public void test1() {
        int result = ugly.nthUglyNumber(10);
        Assert.assertEquals(result,12);
    }

    public void test2() {
        int result = ugly.nthUglyNumber(1);
        Assert.assertEquals(result,1);
    }

    public void test3() {
        int result = ugly.nthUglyNumber(2);
        Assert.assertEquals(result,2);
    }

    public void test4() {
        int result = ugly.nthUglyNumber(3);
        Assert.assertEquals(result,3);
    }

    public void test5() {
        int result = ugly.nthUglyNumber(4);
        Assert.assertEquals(result,4);
    }

    public void test6() {
        int result = ugly.nthUglyNumber(5);
        Assert.assertEquals(result,5);
    }

    public void test7() {
        int result = ugly.nthUglyNumber(7);
        Assert.assertEquals(result,8);
    }

    public void test8(){
        Assert.assertEquals(ugly.nthUglyNumber(11),15);
    }
}
