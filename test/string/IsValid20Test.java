package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/17
 */
public class IsValid20Test {
    private IsValid20 valid = new IsValid20();

    @Test
    public void test1() {
        Assert.assertTrue(valid.isValid("[]"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(valid.isValid("[(]"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(valid.isValid("[(]{"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(valid.isValid("()[]{}"));
    }

    @Test
    public void test5() {
        Assert.assertFalse(valid.isValid("([)]"));
    }

    @Test
    public void test6() {
        Assert.assertTrue(valid.isValid("(){([])()}"));
    }
}
