package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class IsMonotonic896Test extends TestCase {

    private final IsMonotonic896 monotonic = new IsMonotonic896();

    public void test1() {
        boolean result = monotonic.isMonotonic(new int[]{1, 3, 1, 2});
        Assert.assertFalse(result);
    }

    public void test2() {
        boolean result = monotonic.isMonotonic(new int[]{1, 2, 2, 3});
        Assert.assertTrue(result);
    }

    public void test3() {
        boolean result = monotonic.isMonotonic(new int[]{1, 2, 4, 5});
        Assert.assertTrue(result);
    }


    public void test4() {
        boolean result = monotonic.isMonotonic(new int[]{1, 1, 1});
        Assert.assertTrue(result);
    }
}
