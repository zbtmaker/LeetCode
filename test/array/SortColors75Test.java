package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/06
 */
public class SortColors75Test {
    private SortColors75 color = new SortColors75();

    @Test
    public void test1() {
        int[] nums = new int[]{2, 1, 0};
        color.sortColors(nums);
        Assert.assertArrayEquals(nums, new int[]{0, 1, 2});
    }


    @Test
    public void test2() {
        int[] nums = new int[]{2,0, 1};
        color.sortColors(nums);
        Assert.assertArrayEquals(nums, new int[]{0, 1, 2});
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1,0, 2};
        color.sortColors(nums);
        Assert.assertArrayEquals(nums, new int[]{0, 1, 2});
    }

    @Test
    public void test4() {
        int[] nums = new int[]{};
        color.sortColors(nums);
        Assert.assertArrayEquals(nums, new int[]{});
    }

    @Test
    public void test5() {
        int[] nums = new int[]{1,2,0};
        color.sortColors(nums);
        Assert.assertArrayEquals(nums, new int[]{0,1,2});
    }
}