package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2021/04/17
 */
public class Compress443Test extends TestCase {
    private Compress443 compress = new Compress443();

    public void test1() {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c'};
        int len = compress.compress(chars);
        Assert.assertEquals(len, 6);
        System.out.println(Arrays.toString(chars));
    }

    public void test2() {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len = compress.compress(chars);
        Assert.assertEquals(len, 4);
        System.out.println(Arrays.toString(chars));
    }

    public void test3() {
        char[] chars = new char[]{'a', 'b'};
        int len = compress.compress(chars);
        Assert.assertEquals(len, 2);
        System.out.println(Arrays.toString(chars));
    }

    public void test4() {
        char[] chars = new char[]{'a'};
        int len = compress.compress(chars);
        Assert.assertEquals(len, 1);
        System.out.println(Arrays.toString(chars));
    }
}
