package dp;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/08
 */
public class TestNumDecodings639 extends TestCase {

    private NumDecodings639 numDecodings = new NumDecodings639();

    public void test1() {
        int num = numDecodings.numDecodings("1");
        Assert.assertEquals(num, 1);
    }

    public void test2() {
        int num = numDecodings.numDecodings("0");
        Assert.assertEquals(num, 0);
    }


    public void test3() {
        int num = numDecodings.numDecodings("0*");
        Assert.assertEquals(num, 0);
    }

    public void test4() {
        int num = numDecodings.numDecodings("*0");
        Assert.assertEquals(num, 2);
    }

    public void test5() {
        int num = numDecodings.numDecodings("1*");
        Assert.assertEquals(num, 18);
    }


    public void test6() {
        int num = numDecodings.numDecodings("*1");
        Assert.assertEquals(num, 11);
    }

    public void test7() {
        int num = numDecodings.numDecodings("1*001");
        Assert.assertEquals(num, 0);
    }

    public void test8() {
        int num = numDecodings.numDecodings("1*01");
        Assert.assertEquals(num, 2);
    }

    public void test9() {
        int num = numDecodings.numDecodings("**");
        Assert.assertEquals(num, 96);
    }

    public void test10() {
        int num = numDecodings.numDecodings("1**");
        Assert.assertEquals(num, 177);
    }

    public void test11() {
        int num = numDecodings.numDecodings("2**");
        Assert.assertEquals(num, 150);
    }

    public void test12() {
        int num = numDecodings.numDecodings("*1*1*0");
        Assert.assertEquals(num, 404);
    }

    public void test13() {
        int num = numDecodings.numDecodings("204");
        Assert.assertEquals(num, 1);
    }
}
