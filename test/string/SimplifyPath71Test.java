package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/07/03
 */
public class SimplifyPath71Test extends TestCase {
    private SimplifyPath71 path = new SimplifyPath71();


    public void test1() {
        String result = path.simplifyPath("/../");
        Assert.assertEquals(result, "/");
    }

    public void test2() {
        String result = path.simplifyPath("/home//foo/");
        Assert.assertEquals(result, "/home/foo");
    }

    public void test3() {
        String result = path.simplifyPath("/a/./b/../../c/");
        Assert.assertEquals(result, "/c");
    }

    public void test4() {
        String result = path.simplifyPath("/a/../../b/../c//.//");
        Assert.assertEquals(result, "/c");
    }

    public void test5() {
        String result = path.simplifyPath("/a//b////c/d//././/..");
        Assert.assertEquals(result, "/a/b/c");
    }

    public void test6() {
        String result = path.simplifyPath("/../");
        Assert.assertEquals(result, "/");
    }
}
