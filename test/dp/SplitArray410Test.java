package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/07
 */
public class SplitArray410Test extends TestCase {

    private final SplitArray410 split = new SplitArray410();

    public void test1() {
        int res = split.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        Assert.assertEquals(res, 18);
    }
}
