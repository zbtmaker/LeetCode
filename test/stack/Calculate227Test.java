package stack;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/25
 */
public class Calculate227Test extends TestCase {
    private Calculate227 calculate = new Calculate227();

    public void test1() {
        String s = "3+2*2";
        int result = calculate.calculateI(s);
        Assert.assertEquals(result, 7);
    }


    public void test2() {
        String s = "3+12*2";
        int result = calculate.calculateI(s);
        Assert.assertEquals(result, 27);
    }


    public void test3() {
        String s = " 3+ 12/ 2 * 4";
        int result = calculate.calculateI(s);
        Assert.assertEquals(result, 27);
    }

    public void test4() {
        String s = " 3+ 5 / 2";
        int result = calculate.calculateI(s);
        Assert.assertEquals(result, 5);
    }

    public void test5() {
        String s = " 5 / 2";
        int result = calculate.calculateI(s);
        Assert.assertEquals(result, 2);
    }


    public void test6() {
        String s = " 5 ";
        int result = calculate.calculateI(s);
        Assert.assertEquals(result, 5);
    }

    public void test7() {
        String str = "1-1+ 1";
        int result = calculate.calculateI(str);
        Assert.assertEquals(result, 1);
    }

    public void test8() {
        String str = "1-1*8/4*2+ 1";
        int result = calculate.calculateI(str);
        Assert.assertEquals(result, -2);
    }

    public void test9() {
        int result = calculate.calculateI("0-2147483647");
        Assert.assertEquals(result, -2147483647);
    }

    public void test10() {
        int result = calculate.calculateI(" -3+5 / 2 + 1");
        Assert.assertEquals(result, 0);
    }
}
