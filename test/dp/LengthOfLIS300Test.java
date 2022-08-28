package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2019/12/29
 */
public class LengthOfLIS300Test extends TestCase {
    private final LengthOfLIS300 lengthOfLIS = new LengthOfLIS300();

    public void test1() {
        int result = lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        Assert.assertEquals(result, 4);
    }

    public void test2() {
        int result = lengthOfLIS.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        Assert.assertEquals(result, 6);
    }

    public void test3() {
        int result = lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        Assert.assertEquals(result, 4);
    }

    public void test4() {
        int result = lengthOfLIS.lengthOfLIS(new int[]{1, 3, 6, 7, 4, 5, 6});
        Assert.assertEquals(result, 5);
    }
}
