package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class ValidMountainArray941Test extends TestCase {

    private final ValidMountainArray941 valid = new ValidMountainArray941();

    public void test1() {
        boolean result = valid.validMountainArray(new int[]{3, 7, 6, 4, 3, 0, 1, 0});
        Assert.assertFalse(result);
    }

    public void test2() {
        boolean result = valid.validMountainArray(new int[]{3, 5, 5});
        Assert.assertFalse(result);
    }

    public void test3() {
        boolean result = valid.validMountainArray(new int[]{3, 5, 4});
        Assert.assertTrue(result);
    }

    public void test4() {
        boolean result = valid.validMountainArray(new int[]{0, 3, 2, 1});
        Assert.assertTrue(result);
    }

    public void test5() {
        boolean result = valid.validMountainArray(new int[]{1, 2, 3, 4, 5});
        Assert.assertFalse(result);
    }
}
