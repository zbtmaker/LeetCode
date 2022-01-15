package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/09
 */
public class FindMaxAverage643Test extends TestCase {

    private final FindMaxAverage643 find = new FindMaxAverage643();

    public void test1() {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        double result = find.findMaxAverage(nums, 4);
        Assert.assertEquals(String.valueOf(result), "12.75");
    }
}
