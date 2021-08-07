package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/26
 */
public class LargestComponentSize952Test {

    private LargestComponentSize952 largest = new LargestComponentSize952();

    @Test
    public void test1() {
        int result = largest.largestComponentSize(new int[]{20, 50, 9, 63});
        Assert.assertEquals(result, 2);
    }

    @Test
    public void test2() {
        int result = largest.largestComponentSize(new int[]{4, 6, 15, 35});
        Assert.assertEquals(result, 4);
    }

    @Test
    public void test3() {
        int result = largest.largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39});
        Assert.assertEquals(result, 8);
    }
}
