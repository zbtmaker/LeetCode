package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class IntegerBreak343Test extends TestCase {

    private final IntegerBreak343 integerBreak = new IntegerBreak343();

    public void test1() {
        int result = integerBreak.integerBreak(10);
        Assert.assertEquals(result, 36);
    }

    public void test2() {
        int result = integerBreak.integerBreak(8);
        Assert.assertEquals(result, 18);
    }
}
