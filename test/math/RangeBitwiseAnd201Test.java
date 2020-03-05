package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/01
 */
public class RangeBitwiseAnd201Test {

    private RangeBitwiseAnd201 range = new RangeBitwiseAnd201();

    @Test
    public void test1() {
        int result = range.rangeBitwiseAnd(0, 8);
        Assert.assertEquals(result, 0);
    }


    @Test
    public void test2() {
        int result = range.rangeBitwiseAnd(4, 7);
        Assert.assertEquals(result, 4);
    }


    @Test
    public void test3() {
        int result = range.rangeBitwiseAnd(5, 6);
        Assert.assertEquals(result, 4);
    }


    @Test
    public void test4() {
        int result = range.rangeBitwiseAnd(13, 14);
        Assert.assertEquals(result, 12);
    }

    @Test
    public void test5() {
        int result = range.rangeBitwiseAnd(2147483647, 2147483647);
        Assert.assertEquals(result, 2147483647);
    }

    @Test
    public void test6() {
        int result = range.rangeBitwiseAnd(700000000, 2147483641);
        System.out.println(result);
    }

    @Test
    public void test7() {
        int result = range.rangeBitwiseAnd(20000, 2147483647);
        System.out.println(result);
    }


    @Test
    public void test8() {
        int result = range.rangeBitwiseAnd(2048, 2147483647);
        System.out.println(result);
    }

    @Test
    public void test9() {
        int result = range.rangeBitwiseAnd(2049, 4096);
        System.out.println(result);
    }

    @Test
    public void test10() {
        int result = range.rangeBitwiseAnd(2048, 4095);
        System.out.println(result);
    }

    @Test
    public void test11() {
        int result = range.rangeBitwiseAnd(1, 2);
        Assert.assertEquals(result, 0);
    }
}
