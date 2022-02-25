package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/25
 */
public class IsNumber65Test extends TestCase {

    private final IsNumber65 isNumber = new IsNumber65();

    public void test1() {
        boolean result = isNumber.isNumber("1e2");
        Assert.assertTrue(result);
    }

    public void test2() {
        boolean result = isNumber.isNumber("1e-2");
        Assert.assertTrue(result);
    }

    public void test3() {
        boolean result = isNumber.isNumber("1e-.2");
        Assert.assertFalse(result);
    }

    public void test4() {
        boolean result = isNumber.isNumber("abc");
        Assert.assertFalse(result);
    }

    public void test5() {
        boolean result = isNumber.isNumber("1a");
        Assert.assertFalse(result);
    }


    public void test6() {
        boolean result = isNumber.isNumber("1e");
        Assert.assertFalse(result);
    }

    public void test7() {
        boolean result = isNumber.isNumber("1+");
        Assert.assertFalse(result);
    }

    public void test8() {
        boolean result = isNumber.isNumber("1-");
        Assert.assertFalse(result);
    }

    public void test9() {
        boolean result = isNumber.isNumber("1e+2");
        Assert.assertTrue(result);
    }

    public void test10() {
        boolean result = isNumber.isNumber("1e-2");
        Assert.assertTrue(result);
    }

    public void test11() {
        boolean result = isNumber.isNumber("1e-2.");
        Assert.assertFalse(result);
    }

    public void test12() {
        boolean result = isNumber.isNumber("-2.");
        Assert.assertTrue(result);
    }

    public void test13() {
        boolean result = isNumber.isNumber("-2");
        Assert.assertTrue(result);
    }

    public void test14() {
        boolean result = isNumber.isNumber("+2");
        Assert.assertTrue(result);
    }

    public void test15() {
        boolean result = isNumber.isNumber("2");
        Assert.assertTrue(result);
    }

    public void test16() {
        boolean result = isNumber.isNumber(".22.2");
        Assert.assertFalse(result);
    }

    public void test17() {
        boolean result = isNumber.isNumber("-22.2E9");
        Assert.assertTrue(result);
    }

    public void test19() {
        boolean result = isNumber.isNumber("-22.2E+9");
        Assert.assertTrue(result);
    }

    public void test20() {
        boolean result = isNumber.isNumber("-22.2E-9");
        Assert.assertTrue(result);
    }

    public void test21() {
        boolean result = isNumber.isNumber("11e2.2");
        Assert.assertFalse(result);
    }

    public void test22() {
        boolean result = isNumber.isNumber("11e.2");
        Assert.assertFalse(result);
    }

    public void test23() {
        boolean result = isNumber.isNumber("+");
        Assert.assertFalse(result);
    }

    public void test24() {
        boolean result = isNumber.isNumber("-");
        Assert.assertFalse(result);
    }

    public void test25() {
        boolean result = isNumber.isNumber(".");
        Assert.assertFalse(result);
    }

    public void test26() {
        boolean result = isNumber.isNumber("e");
        Assert.assertFalse(result);
    }

    public void test27() {
        boolean result = isNumber.isNumber("+");
        Assert.assertFalse(result);
    }

    public void test28() {
        boolean result = isNumber.isNumber("a67");
        Assert.assertFalse(result);
    }

    public void test29() {
        boolean result = isNumber.isNumber(".+");
        Assert.assertFalse(result);
    }

    public void test30() {
        boolean result = isNumber.isNumber("+.");
        Assert.assertFalse(result);
    }

    public void test31() {
        boolean result = isNumber.isNumber("46.e3");
        Assert.assertTrue(result);
    }
}
