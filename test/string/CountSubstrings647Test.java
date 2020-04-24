package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/14
 */
public class CountSubstrings647Test {
    private CountSubstrings647 count = new CountSubstrings647();

    @Test
    public void test1() {
        int result = count.countSubstrings("abc");
        Assert.assertEquals(result, 3);
    }

    @Test
    public void test2() {
        int result = count.countSubstrings("aaa");
        Assert.assertEquals(result, 6);
    }
}
