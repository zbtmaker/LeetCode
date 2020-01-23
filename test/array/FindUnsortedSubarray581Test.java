package array;

import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/01/19
 */
public class FindUnsortedSubarray581Test {
    private FindUnsortedSubarray581 unsortedSubarray = new FindUnsortedSubarray581();

    public void test1() {
        int len = unsortedSubarray.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        Assert.assertEquals(len, 5);
    }

    public void test2() {
        int len = unsortedSubarray.findUnsortedSubarray(new int[]{2, 4, 6, 8, 10, 9, 15});
        Assert.assertEquals(len, 4);
    }

    public void test3() {
        int len = unsortedSubarray.findUnsortedSubarray(new int[]{2, 4, 6, 8, 9, 10, 15});
        Assert.assertEquals(len, 0);
    }
}
