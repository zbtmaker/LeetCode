package string;

import junit.framework.TestCase;
import org.junit.Assert;


/**
 * @author baitao zou
 * date 2020/07/19
 */
public class LengthLongestPath388Test extends TestCase {

    private LengthLongestPath388 longest = new LengthLongestPath388();

    public void test1() {
        int len = longest.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        Assert.assertEquals(len, 20);
    }

    public void test2() {
        int len = longest.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        Assert.assertEquals(len, 32);
    }

    public void test3() {
        int len = longest.lengthLongestPath("a");
        Assert.assertEquals(len, 0);
    }
}
