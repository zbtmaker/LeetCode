package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class CheckValidString678Test {

    private CheckValidString678 check = new CheckValidString678();

    @Test
    public void test1() {
        boolean result = check.checkValidString("()");
        Assert.assertTrue(result);
    }

    @Test
    public void test2() {
        boolean result = check.checkValidString("(*)");
        Assert.assertTrue(result);
    }

    @Test
    public void test3() {
        boolean result = check.checkValidString("(*))");
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        boolean result = check.checkValidString("*)");
        Assert.assertTrue(result);
    }

    @Test
    public void test5() {
        boolean result = check.checkValidString("(*");
        Assert.assertTrue(result);
    }

    @Test
    public void test6() {
        boolean result = check.checkValidString("((*)");
        Assert.assertTrue(result);
    }

    @Test
    public void test7() {
        boolean result = check.checkValidString("((***)");
        Assert.assertTrue(result);
    }

    @Test
    public void test8() {
        boolean result = check.checkValidString("***)");
        Assert.assertTrue(result);
    }

    @Test
    public void test9() {
        boolean result = check.checkValidString("(***)*");
        Assert.assertTrue(result);
    }

    @Test
    public void test10() {
        boolean result = check.checkValidString("*(()))");
        Assert.assertTrue(result);
    }
}
