package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/10
 */
public class SingleNumber136Test {
    private SingleNumber136 single = new SingleNumber136();

    @Test
    public void test1() {
        int result = single.singleNumber(new int[]{2,1,2});
        Assert.assertEquals(result,1);
    }

    @Test
    public void test2() {
        int result = single.singleNumber(new int[]{1});
        Assert.assertEquals(result,1);
    }
}
