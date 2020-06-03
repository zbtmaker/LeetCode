package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/04
 */
public class NumSquares279Test extends TestCase {

    private NumSquares279 numSquares = new NumSquares279();

    public void test1() {
        int num = numSquares.numSquares(13);
        Assert.assertEquals(num, 2);
    }

    public void test2() {
        int num = numSquares.numSquares(12);
        Assert.assertEquals(num, 3);
    }

    public void test3() {
        int num = numSquares.numSquares(16);
        Assert.assertEquals(num, 1);
    }
}
