package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/11
 */
public class FindMaxForm474Test {

    private FindMaxForm474 maxForm = new FindMaxForm474();

    @Test
    public void test1() {
        int max = maxForm.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        Assert.assertEquals(max, 4);
    }

    @Test
    public void test2() {
        int max = maxForm.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
        Assert.assertEquals(max, 2);
    }

    @Test
    public void test3() {
        int max = maxForm.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 3, 4);
        Assert.assertEquals(max, 3);
    }
}
