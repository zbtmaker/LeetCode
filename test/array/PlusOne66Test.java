package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/16
 */
public class PlusOne66Test extends TestCase {

    private final PlusOne66 plusOne = new PlusOne66();

    public void test1() {
        int[] result = plusOne.plusOne(new int[]{1, 2, 3});
        Assert.assertArrayEquals(result, new int[]{1, 2, 4});
    }

    public void test2() {
        int[] result = plusOne.plusOne(new int[]{4, 3, 2, 1});
        Assert.assertArrayEquals(result, new int[]{4, 3, 2, 2});
    }
}
