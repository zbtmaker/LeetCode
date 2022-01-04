package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/05
 */
public class FairCandySwap888Test extends TestCase {

    private final FairCandySwap888 candySwap = new FairCandySwap888();

    public void test1() {
        int[] result = candySwap.fairCandySwap(new int[]{1, 1}, new int[]{2, 2});
        Assert.assertArrayEquals(result, new int[]{0, 0});
    }

    public void test2() {
        int[] result = candySwap.fairCandySwap(new int[]{1, 2}, new int[]{2, 3});
        Assert.assertArrayEquals(result, new int[]{1, 1});
    }

    public void test3() {
        int[] result = candySwap.fairCandySwap(new int[]{2}, new int[]{1, 3});
        Assert.assertArrayEquals(result, new int[]{0, 1});
    }

    public void test4() {
        int[] result = candySwap.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
        Assert.assertArrayEquals(result, new int[]{2, 1});
    }
}
