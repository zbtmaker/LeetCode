package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2020/12/20
 */
public class TestRemoveDuplicates26 extends TestCase {
    private RemoveDuplicates26 remove = new RemoveDuplicates26();

    public void test1() {
        int[] nums = new int[]{};
        int len = remove.removeDuplicates(nums);
        Assert.assertEquals(len, 0);
        Assert.assertArrayEquals(nums, new int[]{});
    }

    public void test2() {
        int[] nums = new int[]{1};
        int len = remove.removeDuplicates(nums);
        Assert.assertEquals(len, 1);
        Assert.assertArrayEquals(nums, new int[]{1});
    }

    public void test3() {
        int[] nums = new int[]{1, 1};
        int len = remove.removeDuplicates(nums);
        Assert.assertEquals(len, 1);
        Assert.assertArrayEquals(nums, new int[]{1, 1});
    }

    public void test4() {
        int[] nums = new int[]{1, 1, 2};
        int len = remove.removeDuplicates(nums);
        Assert.assertEquals(len, 2);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 2});
    }

    public void test5() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int len = remove.removeDuplicates(nums);
        Assert.assertEquals(len, 3);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 2, 2, 3});
    }
}
