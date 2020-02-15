package dp;

import org.junit.Assert;
import org.junit.Test;

public class MaxProduct152Test {

    private MaxProduct152 maxProduct152 = new MaxProduct152();

    /**
     * 测试用例1:[2,3,-2,4]
     */
    @Test
    public void test1() {
        int max = maxProduct152.maxProduct(new int[]{2, 3, -2, 4});
        Assert.assertEquals(max, 6);
    }

    /**
     * 测试用例2:[-2,0,-1]
     */
    @Test
    public void test2() {
        int max = maxProduct152.maxProduct(new int[]{-2, 0, -1});
        Assert.assertEquals(max, 0);
    }

    /**
     * 测试用例3:[-2,0]
     */
    @Test
    public void test3() {
        int max = maxProduct152.maxProduct(new int[]{-2, 0});
        Assert.assertEquals(max, 0);
    }

    /**
     * 测试用例4:[-2]
     */
    @Test
    public void test4() {
        int max = maxProduct152.maxProduct(new int[]{-2});
        Assert.assertEquals(max, -2);
    }

    /**
     * 测试用例5:[0,2]
     */
    @Test
    public void test5() {
        int max = maxProduct152.maxProduct(new int[]{0, 2});
        Assert.assertEquals(max, 2);
    }


    @Test
    public void test6() {
        int max = maxProduct152.maxProduct(new int[]{1, 0, -1, 2, 3, -5, -2});
        Assert.assertEquals(max, 60);
    }


    @Test
    public void test7() {
        int max = maxProduct152.maxProduct(new int[]{2, -5, -2, -4, 3});
        Assert.assertEquals(max, 24);
    }

    @Test
    public void test8() {
        int max = maxProduct152.maxProduct(new int[]{-4, -3});
        Assert.assertEquals(max, 12);
    }

    @Test
    public void test9() {
        int max = maxProduct152.maxProduct(new int[]{-1, -2, -3, 0});
        Assert.assertEquals(max, 6);
    }
    @Test
    public void test10() {
        int max = maxProduct152.maxProduct(new int[]{-2,-1,-2});
        Assert.assertEquals(max, 2);
    }

}
