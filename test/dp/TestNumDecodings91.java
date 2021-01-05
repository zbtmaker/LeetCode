package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/05/07
 */
public class TestNumDecodings91 extends TestCase {

    private NumDecodings91 decodings = new NumDecodings91();

    public void test1() {
        int count = decodings.numDecodings("12101");
        Assert.assertEquals(count, 2);
    }

    public void test2() {
        int count = decodings.numDecodings("12");
        Assert.assertEquals(count, 2);
    }

    public void test3() {
        int count = decodings.numDecodings("226");
        Assert.assertEquals(count, 3);
    }

    public void test4() {
        int count = decodings.numDecodings("2260");
        Assert.assertEquals(count, 0);
    }

    public void test5() {
        int count = decodings.numDecodings("110");
        Assert.assertEquals(count, 1);
    }

    public void test6() {
        int count = decodings.numDecodings("27");
        Assert.assertEquals(count, 1);
    }

    public void test7() {
        int count = decodings.numDecodings("101");
        Assert.assertEquals(count, 1);
    }
}
