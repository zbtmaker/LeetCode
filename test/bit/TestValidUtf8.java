package bit;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/25
 */
public class TestValidUtf8 extends TestCase {

    private ValidUtf8339 valid = new ValidUtf8339();

    public void test1() {
        boolean result = valid.validUtf8(new int[]{197, 130, 1});
        Assert.assertTrue(result);
    }

    public void test2() {
        boolean result = valid.validUtf8(new int[]{197, 130, 1, 1});
        Assert.assertTrue(result);
    }

    public void test3() {
        boolean result = valid.validUtf8(new int[]{1, 1, 1, 1});
        Assert.assertTrue(result);
    }

    public void test4() {
        boolean result = valid.validUtf8(new int[]{235, 140, 4});
        Assert.assertFalse(result);
    }

    public void test5() {
        boolean result = valid.validUtf8(new int[]{128, 1});
        Assert.assertFalse(result);
    }

    public void test6() {
        boolean result = valid.validUtf8(new int[]{255, 1});
        Assert.assertFalse(result);
    }

    public void test7() {
        boolean result = valid.validUtf8(new int[]{248, 130, 130, 130});
        Assert.assertFalse(result);
    }

    public void test8() {
        boolean result = valid.validUtf8(new int[]{240, 130, 130, 130});
        Assert.assertTrue(result);
    }


    public void test9() {
        boolean result = valid.validUtf8(new int[]{250, 145, 145, 145, 145});
        Assert.assertFalse(result);
    }
}
