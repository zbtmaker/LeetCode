package dp;

import array.Trap42;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/10/28
 */
public class Trap42Test extends TestCase {

    private Trap42 trap = new Trap42();

    public void test1() {
        int result = trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assert.assertEquals(result, 6);
    }

    public void test2() {
        int result = trap.trap(new int[]{0, 1, 0});
        Assert.assertEquals(result, 0);
    }


    public void test3() {
        int result = trap.trap(new int[]{4, 2, 0, 3, 2, 5});
        Assert.assertEquals(result, 9);
    }

    public void test4() {
        int result = trap.trap(new int[]{0, 1});
        Assert.assertEquals(result, 0);
    }

    public void test5() {
        int result = trap.trap(new int[]{1});
        Assert.assertEquals(result, 0);
    }

    public void test6() {
        int result = trap.trap(new int[]{});
        Assert.assertEquals(result, 0);
    }
}
