package array;

import junit.framework.TestCase;
import org.junit.Assert;

public class RangeBitwiseAnd201Test extends TestCase {

    private final RangeBitwiseAnd201 rangeBitWiseAnd201 = new RangeBitwiseAnd201();

    public void test1() {
        int m = 5;
        int n = 7;
        int result = rangeBitWiseAnd201.rangeBitwiseAnd(m, n);
        Assert.assertEquals(result, 4);
    }

    public void test2() {
        int m = 0;
        int n = 1;
        int result = rangeBitWiseAnd201.rangeBitwiseAnd(m, n);
        Assert.assertEquals(result, 0);
    }
}
