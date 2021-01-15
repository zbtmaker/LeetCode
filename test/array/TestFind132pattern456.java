package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/16
 */
public class TestFind132pattern456 extends TestCase {

    private Find132pattern456 find = new Find132pattern456();

    public void test1() {
        boolean result = find.find132pattern(new int[]{});
        Assert.assertFalse(result);
    }

    public void test2() {
        boolean result = find.find132pattern(new int[]{1});
        Assert.assertFalse(result);
    }


    public void test3() {
        boolean result = find.find132pattern(new int[]{1, 2, 3});
        Assert.assertFalse(result);
    }

    public void test4() {
        boolean result = find.find132pattern(new int[]{1, 3, 2});
        Assert.assertTrue(result);
    }

    public void test5() {
        boolean result = find.find132pattern(new int[]{2, 3, 1});
        Assert.assertFalse(result);
    }

    public void test6() {
        boolean result = find.find132pattern(new int[]{1, 4, 0, -1, -2, -3, -1, -2});
        Assert.assertTrue(result);
    }
}
