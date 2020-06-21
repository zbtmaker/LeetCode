package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/20
 */
public class MaximumGap164Test extends TestCase {
    private MaximumGap164 maximumGap164 = new MaximumGap164();

    public void test1() {
        int max = maximumGap164.maximumGap(new int[]{});
        Assert.assertEquals(max, 0);
    }

    public void test2() {
        int max = maximumGap164.maximumGap(new int[]{1, 3, 9, 6});
        Assert.assertEquals(max, 3);
    }
}
