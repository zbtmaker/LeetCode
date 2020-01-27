package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/27
 */
public class MaxSlidingWindow239Test {
    private MaxSlidingWindow239 slide = new MaxSlidingWindow239();

    @Test
    public void test1() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 3);
        Assert.assertArrayEquals(result, new int[]{3, 3, 5, 5, 6, 7});
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 4);
        Assert.assertArrayEquals(result, new int[]{3, 5, 5, 6, 7});
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 5);
        Assert.assertArrayEquals(result, new int[]{5, 5, 6, 7});
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 6);
        Assert.assertArrayEquals(result, new int[]{5, 6, 7});
    }

    @Test
    public void test5() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 7);
        Assert.assertArrayEquals(result, new int[]{6, 7});
    }

    @Test
    public void test6() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 8);
        Assert.assertArrayEquals(result, new int[]{7});
    }

    @Test
    public void test8() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 8);
        Assert.assertArrayEquals(result, new int[]{7});
    }

    @Test
    public void test9() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slide.maxSlidingWindow(nums, 9);
        Assert.assertArrayEquals(result, new int[]{7});
    }
}
