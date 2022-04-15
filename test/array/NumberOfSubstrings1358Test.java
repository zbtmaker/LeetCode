package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/15
 */
public class NumberOfSubstrings1358Test extends TestCase {

    private final NumberOfSubstrings1358 num = new NumberOfSubstrings1358();

    public void test1() {
        int res = num.numberOfSubstrings("abc");
        Assert.assertEquals(res, 1);
    }

    public void test2() {
        int res = num.numberOfSubstrings("abcabc");
        Assert.assertEquals(res, 10);
    }

    public void test3() {
        int res = num.numberOfSubstrings("aaacb");
        Assert.assertEquals(res, 3);
    }
}
