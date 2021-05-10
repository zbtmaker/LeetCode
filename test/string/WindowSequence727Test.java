package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/05/09
 */
public class WindowSequence727Test extends TestCase {
    private WindowSequence727 window = new WindowSequence727();

    public void test1() {
        String r = window.minWindow("abcdebdde", "bde");
        Assert.assertEquals(r, "bcde");
    }

    public void test2() {
        String r = window.minWindow("abcbdebdde", "bde");
        Assert.assertEquals(r, "bde");
    }
}
