package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/16
 */
public class FirstMissingPositive41Test extends TestCase {
    private FirstMissingPositive41 missing = new FirstMissingPositive41();

    public void test1() {
        int result = missing.firstMissingPositive(new int[]{1, 2, 0});
        Assert.assertEquals(result, 3);
    }

    public void test2() {
        int result = missing.firstMissingPositive(new int[]{-1, -2, 0});
        Assert.assertEquals(result, 1);
    }

    public void test3() {
        int result = missing.firstMissingPositive(new int[]{-1, -2, 0, 4, 3, 7});
        Assert.assertEquals(result, 1);
    }

    public void test4() {
        int result = missing.firstMissingPositive(new int[]{Integer.MAX_VALUE});
        Assert.assertEquals(result, 1);
    }
}
