package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class TwoSum1Test extends TestCase {

    private final TwoSum1 twoSum = new TwoSum1();

    public void test1() {
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertArrayEquals(result, new int[]{0, 1});
    }
}
