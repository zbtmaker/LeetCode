package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/08/08
 */
public class DetectCapitalUse520Test extends TestCase {

    private DetectCapitalUse520 detect = new DetectCapitalUse520();

    public void test1() {
        boolean flag = detect.detectCapitalUse("leetcode");
        Assert.assertTrue(flag);
    }

    public void test2() {
        boolean flag = detect.detectCapitalUse("flaG");
        Assert.assertFalse(flag);
    }

    public void test3() {
        boolean flag = detect.detectCapitalUse("FLAG");
        Assert.assertTrue(flag);
    }
}
