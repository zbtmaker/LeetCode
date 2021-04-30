package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/20
 */
public class LongestOnes1004Test extends TestCase {
    private LongestOnes1004 longest = new LongestOnes1004();

    public void test1() {
        int max = longest.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        Assert.assertEquals(max, 6);
    }


    public void test2() {
        int max = longest.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1}, 2);
        Assert.assertEquals(max, 6);
    }

    public void test3() {
        int max = longest.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1}, 2);
        Assert.assertEquals(max, 10);
    }
}
