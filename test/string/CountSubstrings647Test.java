package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/04/14
 */
public class CountSubstrings647Test extends TestCase {
    private final CountSubstrings647 count = new CountSubstrings647();

    public void test1() {
        int result = count.countSubstrings("abc");
        Assert.assertEquals(result, 3);
    }

    public void test2() {
        int result = count.countSubstrings("aaa");
        Assert.assertEquals(result, 6);
    }
}
