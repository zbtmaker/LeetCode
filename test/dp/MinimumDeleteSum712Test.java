package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/05/29
 */
public class MinimumDeleteSum712Test extends TestCase {

    private MinimumDeleteSum712 delete = new MinimumDeleteSum712();

    public void test1() {
        int min = delete.minimumDeleteSum("sea", "eat");
        Assert.assertEquals(min, 231);
    }

    public void test2() {
        int min = delete.minimumDeleteSum("delete", "leet");
        Assert.assertEquals(min, 403);
    }

    public void test3() {
        int min = delete.minimumDeleteSum("sjfqkfxqoditw", "fxymelgo");
        Assert.assertEquals(min, 1638);
    }
}
