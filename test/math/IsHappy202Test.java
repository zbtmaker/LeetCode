package math;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author baitao zou
 * date 2020/01/25
 */
public class IsHappy202Test {
    private IsHappy202 happy = new IsHappy202();

    @Test
    public void test1() {
        Assert.assertEquals(happy.isHappy(19), true);
    }


    @Test
    public void test2() {
        Assert.assertEquals(happy.isHappy(189), false);
    }


    @Test
    public void test3() {
        Assert.assertEquals(happy.isHappy(8), true);
    }
}
