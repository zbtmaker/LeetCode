package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/18
 */
public class NextPermutation31Test extends TestCase {
    private final NextPermutation31 next = new NextPermutation31();

    public void test1() {
        int[] nums = new int[]{4, 1, 3, 2};
        next.nextPermutation(nums);
        Assert.assertArrayEquals(nums, new int[]{4, 2, 1, 3});
    }

    public void test2() {
        int[] nums = new int[]{1, 2, 3, 4};
        next.nextPermutation(nums);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 4, 3});
    }

    public void test3() {
        int[] nums = new int[]{4, 3, 2, 1};
        next.nextPermutation(nums);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 4});
    }

    public void test4() {
        int[] nums = new int[]{2, 3, 4, 1};
        next.nextPermutation(nums);
        Assert.assertArrayEquals(nums, new int[]{2, 4, 1, 3});
    }
}
