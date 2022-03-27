package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/27
 */
public class ReverseString344Test extends TestCase {
    private final ReverseString344 reverse = new ReverseString344();

    public void test1() {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverse.reverseString(s);
        Assert.assertArrayEquals(s, new char[]{'o', 'l', 'l', 'e', 'h'});
    }

    public void test2() {
        char[] s = new char[]{'h', 'e'};
        reverse.reverseString(s);
        Assert.assertArrayEquals(s, new char[]{'e', 'h'});
    }
}
