package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/05/30
 */
public class SubarraysWithKDistinct992Test extends TestCase {

    private SubarraysWithKDistinct992 subArrays = new SubarraysWithKDistinct992();

    public void test1() {
        int size = subArrays.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
        Assert.assertEquals(size, 7);
    }

    public void test2() {
        int size = subArrays.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3);
        Assert.assertEquals(size, 3);
    }

    public void test3() {
        int size = subArrays.subarraysWithKDistinct(new int[]{1, 1, 2, 2, 3}, 2);
        Assert.assertEquals(size, 6);
    }

    public void test4() {
        int size = subArrays.subarraysWithKDistinct(new int[]{2, 1, 1, 1, 2}, 1);
        Assert.assertEquals(size, 8);
    }
}
