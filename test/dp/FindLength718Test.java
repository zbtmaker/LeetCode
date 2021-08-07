package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/05/07
 */
public class FindLength718Test extends TestCase {

    private FindLength718 find = new FindLength718();

    public void test1() {
        int len = find.findLengthByCompress(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        Assert.assertEquals(len, 3);
    }
}
