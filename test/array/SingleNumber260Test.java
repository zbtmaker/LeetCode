package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/10
 */
public class SingleNumber260Test {
    public SingleNumber260 single = new SingleNumber260();

    @Test
    public void test1() {
        int[] result = single.singleNumber(new int[]{1, 2, 2, 3, 3, 5});
        Assert.assertArrayEquals(result, new int[]{1, 5});
    }

    @Test
    public void test2() {
        int[] result = single.singleNumber(new int[]{1, 2, 2, 5});
        Assert.assertArrayEquals(result, new int[]{1, 5});
    }

    @Test
    public void test3() {
        int[] result = single.singleNumber(new int[]{1, 5});
        Assert.assertArrayEquals(result, new int[]{1, 5});
    }
}
