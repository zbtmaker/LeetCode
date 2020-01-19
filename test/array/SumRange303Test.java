package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/19
 */
public class SumRange303Test {

    private SumRange303 range303 = new SumRange303(new int[]{-2, 0, 3, -5, 2, -1});

    @Test
    public void test1(){
        Assert.assertEquals(range303.sumRange(0,5),-3);
    }

    @Test
    public void test2(){
        Assert.assertEquals(range303.sumRange(0,2),1);
    }

    @Test
    public void test3(){
        Assert.assertEquals(range303.sumRange(2,5),-1);
    }
}
