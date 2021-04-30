package stack;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/13
 */
public class Calculate772Test extends TestCase {


    public void test1() {
        Calculate772 calculate = new Calculate772();
        int result = calculate.calculate("(1 + 2)");
        Assert.assertEquals(result, 3);
    }

    public void test2() {
        Calculate772 calculate = new Calculate772();
        int result = calculate.calculate("1 + 2");
        Assert.assertEquals(result, 3);
    }
}
