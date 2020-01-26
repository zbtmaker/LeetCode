package stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/25
 */
public class Calculate227Test {
    private Calculate227 calculate = new Calculate227();

    @Test
    public void test1() {
        String s = "3+2*2";
        int result = calculate.calculate(s);
        Assert.assertEquals(result, 7);
    }


    @Test
    public void test2() {
        String s = "3+12*2";
        int result = calculate.calculate(s);
        Assert.assertEquals(result, 27);
    }


    @Test
    public void test3() {
        String s = " 3+ 12/ 2 * 4";
        int result = calculate.calculate(s);
        Assert.assertEquals(result, 27);
    }

    @Test
    public void test4() {
        String s = " 3+ 5 / 2";
        int result = calculate.calculate(s);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void test5() {
        String s = " 5 / 2";
        int result = calculate.calculate(s);
        Assert.assertEquals(result, 2);
    }


    @Test
    public void test6() {
        String s = " 5 ";
        int result = calculate.calculate(s);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void test7 (){
        String str = "1-1+ 1";
        int result = calculate.calculate(str);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test8 (){
        String str = "1-1*8/4*2+ 1";
        int result = calculate.calculate(str);
        Assert.assertEquals(result, -2);
    }
}
