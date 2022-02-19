package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class Rotate189Test extends TestCase {

    private final Rotate189 rotate = new Rotate189();

    public void test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 1);
        Assert.assertArrayEquals(nums, new int[]{7, 1, 2, 3, 4, 5, 6});
    }

    public void test2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 2);
        Assert.assertArrayEquals(nums, new int[]{6, 7, 1, 2, 3, 4, 5});
    }

    public void test3() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 3);
        Assert.assertArrayEquals(nums, new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    public void test4() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 4);
        Assert.assertArrayEquals(nums, new int[]{4, 5, 6, 7, 1, 2, 3});
    }

    public void test5() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 5);
        Assert.assertArrayEquals(nums, new int[]{3, 4, 5, 6, 7, 1, 2});
    }

    public void test6() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 6);
        Assert.assertArrayEquals(nums, new int[]{2, 3, 4, 5, 6, 7, 1});
    }

    public void test7() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 7);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}
