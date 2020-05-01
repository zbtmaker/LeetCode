package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/28
 */
public class MinDistance72Test {

    private MinDistance72 minDistance = new MinDistance72();

    @Test
    public void test1() {
        int min = minDistance.minDistance("horse", "ros");
        Assert.assertEquals(min, 3);
    }

    @Test
    public void test2() {
        int min = minDistance.minDistance("intention", "execution");
        Assert.assertEquals(min, 5);
    }

    @Test
    public void test3() {
        int min = minDistance.minDistance("","");
        Assert.assertEquals(min,0);
    }

    @Test
    public void test4() {
        int min = minDistance.minDistance("a","");
        Assert.assertEquals(min,1);
    }
    @Test
    public void test5() {
        int min = minDistance.minDistance("","a");
        Assert.assertEquals(min,1);
    }

}
