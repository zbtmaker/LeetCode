package dp;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/29
 */
public class MaxUncrossedLines1035Test extends TestCase {

    private MaxUncrossedLines1035 uncrossed = new MaxUncrossedLines1035();


    public void test1() {
        int lines = uncrossed.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4});
        Assert.assertEquals(lines, 2);
    }

    public void test2() {
        int lines = uncrossed.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2});
        Assert.assertEquals(lines, 3);
    }

    public void test3() {
        int lines = uncrossed.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1});
        Assert.assertEquals(lines, 2);
    }
}
