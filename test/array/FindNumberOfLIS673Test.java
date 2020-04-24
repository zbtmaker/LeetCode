package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/19
 */
public class FindNumberOfLIS673Test {

    private FindNumberOfLIS673 lis = new FindNumberOfLIS673();

    @Test
    public void test1() {
        int count = lis.findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
         Assert.assertEquals(count, 5);
    }

    @Test
    public void test2() {
        int count = lis.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        Assert.assertEquals(count, 2);
    }

    @Test
    public void test3() {
        int count = lis.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        Assert.assertEquals(count, 3);
    }

    @Test
    public void test4() {
        int count = lis.findNumberOfLIS(new int[]{2, 2, 4, 2, 2});
        Assert.assertEquals(count, 2);
    }

    @Test
    public void test5() {
        int count = lis.findNumberOfLIS(new int[]{2, 2, 4, 4, 3});
        Assert.assertEquals(count, 6);
    }
}
