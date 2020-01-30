package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/29
 */
public class FindPeakElement162Test {
    private FindPeakElement162 peak = new FindPeakElement162();

    @Test
    public void test1() {
        int result = peak.findPeakElement(new int[]{1, 2, 3, 1});
        Assert.assertEquals(result, 2);
    }

    @Test
    public void test2() {
        int result = peak.findPeakElement(new int[]{1,2,1,3,5,6,4});
        Assert.assertEquals(result, 1);
    }
}
