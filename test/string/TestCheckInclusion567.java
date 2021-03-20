package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/20
 */
public class TestCheckInclusion567 extends TestCase {
    private CheckInclusion567 check = new CheckInclusion567();

    public void test1() {
        boolean result = check.checkInclusion("ab", "eidbaooo");
        Assert.assertTrue(result);
    }

    public void test2() {
        boolean result = check.checkInclusion("ab", "eidboaoo");
        Assert.assertFalse(result);
    }

    public void test3() {
        boolean result = check.checkInclusion("adc", "dcda");
        Assert.assertTrue(result);
    }
    public void test4(){
        boolean result = check.checkInclusion("a","ab");
        Assert.assertTrue(result);
    }
}
