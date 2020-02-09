package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/09
 */
public class MyAtoi8Test {

    private MyAtoi8 atoi = new MyAtoi8();

    @Test
    public void test1() {
        long result = atoi.myAtoi("42");
        Assert.assertEquals(result, 42);
    }

    @Test
    public void test2() {
        int result = atoi.myAtoi("-42");
        Assert.assertEquals(result, -42);
    }

    @Test
    public void test3() {
        int result = atoi.myAtoi("4193 with words");
        Assert.assertEquals(result, 4193);
    }

    @Test
    public void test4() {
        int result = atoi.myAtoi("words and 987");
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test5() {
        int result = atoi.myAtoi("-91283472332");
        Assert.assertEquals(result, Integer.MIN_VALUE);
    }

    @Test
    public void test6() {
        int result = atoi.myAtoi("   ");
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test7() {
        int result = atoi.myAtoi("   +0 123");
        Assert.assertEquals(result, 0);
    }


    @Test
    public void test8() {
        int result = atoi.myAtoi("-000000000000001");
        Assert.assertEquals(result, -1);
    }

    @Test
    public void test9() {
        int result = atoi.myAtoi("  0000000000012345678");
        Assert.assertEquals(result, 12345678);
    }


    @Test
    public void test10() {
        int result = atoi.myAtoi("-000000000000000000000000000000000000000000000000000000000000000000000000000001");
        Assert.assertEquals(result, -1);
    }

    @Test
    public void test11() {
        int result = atoi.myAtoi("-1");
        Assert.assertEquals(result, -1);
    }

    @Test
    public void test12() {
        int result = atoi.myAtoi("+1");
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test13() {
        int result = atoi.myAtoi("-01");
        Assert.assertEquals(result, -1);
    }

    @Test
    public void test14() {
        int result = atoi.myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459");
        Assert.assertEquals(result, Integer.MAX_VALUE);
    }

    @Test
    public void test15() {
        long max = (long) Integer.MIN_VALUE;
        String longMaxString = String.valueOf(-max);
        int result = atoi.myAtoi(longMaxString);
        Assert.assertEquals(result, Integer.MAX_VALUE);
    }

    @Test
    public void test16() {
        long max = (long) Integer.MIN_VALUE;
        String longMaxString = String.valueOf(max);
        int result = atoi.myAtoi(longMaxString);
        Assert.assertEquals(result, Integer.MIN_VALUE);
    }
}
