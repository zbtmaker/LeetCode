package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/23
 */
public class MaxSubarraySumCircular918Test {
    public MaxSubarraySumCircular918 sumCircular = new MaxSubarraySumCircular918();

    @Test
    public void test1(){
        Assert.assertEquals(sumCircular.maxSubarraySumCircular(new int[]{1,-2,3,-2}),3);
    }

    @Test
    public void test2(){
        Assert.assertEquals(sumCircular.maxSubarraySumCircular(new int[]{5,-3,5}),10);
    }

    @Test
    public void test3(){
        Assert.assertEquals(sumCircular.maxSubarraySumCircular(new int[]{3,-1,2,-1}),4);
    }

    @Test
    public void test4(){
        Assert.assertEquals(sumCircular.maxSubarraySumCircular(new int[]{3,-2,2,-3}),3);
    }

    @Test
    public void test5(){
        Assert.assertEquals(sumCircular.maxSubarraySumCircular(new int[]{-2,-3,-1}),-1);
    }
}
