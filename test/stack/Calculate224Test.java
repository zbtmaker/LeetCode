package stack;

import junit.framework.TestCase;
import org.junit.Assert;
import stack.Calculate224;

/**
 * @author baitao zou
 * date 2020/05/01
 */
public class Calculate224Test extends TestCase {

    private Calculate224 calculate = new Calculate224();

    public void test1() {
        int result = calculate.calculateI("1 + 1");
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        int result = calculate.calculateI("-1");
        Assert.assertEquals(result, -1);
    }

    public void test3() {
        int result = calculate.calculateI("(1 + 1)");
        Assert.assertEquals(result, 2);
    }

    public void test4() {
        int result = calculate.calculateI("(1+(4+5+2)-3)+(6+8)");
        Assert.assertEquals(result, 23);
    }
}
