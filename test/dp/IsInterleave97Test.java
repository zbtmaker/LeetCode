package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/10/31
 */
public class IsInterleave97Test extends TestCase {
    private IsInterleave97 isInterleave = new IsInterleave97();

    public void test1() {
        boolean flag = isInterleave.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        Assert.assertTrue(flag);
    }

    public void test2() {
        boolean flag = isInterleave.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        Assert.assertFalse(flag);
    }


    public void test3() {
        boolean flag = isInterleave.isInterleave("", "", "");
        Assert.assertTrue(flag);
    }

    public void test4() {
        boolean flag = isInterleave.isInterleave("", "abc", "bac");
        Assert.assertFalse(flag);
    }

    public void test5() {
        boolean flag = isInterleave.isInterleave("aabcc", "abad", "aabccadbd");
        Assert.assertFalse(flag);
    }
}
