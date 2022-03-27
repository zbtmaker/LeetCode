package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/27
 */
public class Multiply43Test extends TestCase {

    private final Multiply43 multiply = new Multiply43();

    public void test1() {
        String res = multiply.multiply("9113", "0");
        Assert.assertEquals(res, "0");
    }
}
