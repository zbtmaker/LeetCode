package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/04/18
 */
public class CompressionII1531Test extends TestCase {
    public CompressionII1531 compress = new CompressionII1531();

    public void test1() {
        int len = compress.getLengthOfOptimalCompression("aaabcccd", 2);
        Assert.assertEquals(len, 4);
    }

    public void test2() {
        int len = compress.getLengthOfOptimalCompression("aabbaa", 2);
        Assert.assertEquals(len, 2);
    }

    public void test3() {
        int len = compress.getLengthOfOptimalCompression("aaaaaaaaaaa", 0);
        Assert.assertEquals(len, 3);
    }

    public void test4() {
        int len = compress.getLengthOfOptimalCompression("aaaaaaaaaaa", 2);
        Assert.assertEquals(len, 2);
    }

    public void test5() {
        int len = compress.getLengthOfOptimalCompression("aaaaaaaaaaa", 10);
        Assert.assertEquals(len, 1);
    }
}
