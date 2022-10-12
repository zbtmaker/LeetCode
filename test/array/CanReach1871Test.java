package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/10
 */
public class CanReach1871Test extends TestCase {

    private final CanReach1871 canReach = new CanReach1871();

    public void test1() {
        boolean ans = canReach.canReach("0000000000", 2, 5);
        Assert.assertTrue(ans);
    }

    public void test2() {
        boolean ans = canReach.canReach("011010", 2, 3);
        Assert.assertTrue(ans);
    }

    public void test3() {
        boolean ans = canReach.canReach("01100", 2, 3);
        Assert.assertFalse(ans);
    }

    public void test4() {
        boolean ans = canReach.canReach("01", 1, 1);
        Assert.assertFalse(ans);
    }

    public void test5() {
        boolean ans = canReach.canReach("011001110001000", 3, 5);
        Assert.assertTrue(ans);
    }

    public void test6() {
        boolean ans = canReach.canReach("00", 1, 1);
        Assert.assertTrue(ans);
    }

    public void test7() {
        boolean ans = canReach.canReach("011000001011110000", 4, 7);
        Assert.assertFalse(ans);
    }
}
