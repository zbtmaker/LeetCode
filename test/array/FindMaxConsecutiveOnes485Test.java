package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/20
 */
public class FindMaxConsecutiveOnes485Test extends TestCase {
    private FindMaxConsecutiveOnes485 find = new FindMaxConsecutiveOnes485();

    public void test1() {
        int max = find.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        Assert.assertEquals(max, 3);
    }
}
