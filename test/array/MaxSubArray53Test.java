package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class MaxSubArray53Test extends TestCase {

    private final MaxSubArray53 maxSubArray = new MaxSubArray53();

    public void test1() {
        int result = maxSubArray.maxSubArray(new int[]{-2, -1, 2});
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        int result = maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assert.assertEquals(result, 6);
    }
}
