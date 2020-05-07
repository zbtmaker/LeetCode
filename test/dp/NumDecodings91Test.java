package dp;

import dp.NumDecodings91;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/07
 */
public class NumDecodings91Test {

    private NumDecodings91 decodings = new NumDecodings91();

    @Test
    public void test1() {
        int count = new NumDecodings91().numDecodings("12101");
        Assert.assertEquals(count, 2);
    }

    @Test
    public void test2() {
        int count = new NumDecodings91().numDecodings("12");
        Assert.assertEquals(count, 2);
    }

    @Test
    public void test3() {
        int count = new NumDecodings91().numDecodings("226");
        Assert.assertEquals(count, 3);
    }

    @Test
    public void test4() {
        int count = new NumDecodings91().numDecodings("2260");
        Assert.assertEquals(count, 0);
    }

    @Test
    public void test5() {
        int count = new NumDecodings91().numDecodings("110");
        Assert.assertEquals(count, 1);
    }

    @Test
    public void test6() {
        int count = new NumDecodings91().numDecodings("27");
        Assert.assertEquals(count, 1);
    }

    @Test
    public void test7() {
        int count = new NumDecodings91().numDecodings("101");
        Assert.assertEquals(count, 1);
    }
}
