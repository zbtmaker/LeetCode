package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/23
 */
public class TestMaxSatisfied1052 extends TestCase {
    private MaxSatisfied1052 maxSatisfied = new MaxSatisfied1052();

    public void test1() {
        int max = maxSatisfied.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
        Assert.assertEquals(max, 16);
    }
}
