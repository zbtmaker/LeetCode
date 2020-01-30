package array;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/30
 */
public class Merge88Test {
    private Merge88 merge = new Merge88();

    @Test
    public void test1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(nums1, new int[]{1, 2, 2, 3, 5, 6});
    }
}
