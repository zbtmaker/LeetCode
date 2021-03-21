package bit;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/05
 */
public class TestNumberOf1Bits191 extends TestCase {
    private NumberOf1Bits191 num = new NumberOf1Bits191();

    public void test1(){
        int count = num.hammingWeight(-3);
        Assert.assertEquals(count,31);
    }
}
