package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/16
 */
public class HIndex275Test extends TestCase {

    private HIndex275 hIndex = new HIndex275();

    public void test1() {
        int max = hIndex.hIndex(new int[]{0, 1, 3, 5, 6});
        Assert.assertEquals(max, 3);
    }

    public void test2() {
        int max = hIndex.hIndex(new int[]{0, 1, 3, 3, 5, 6});
        Assert.assertEquals(max, 3);
    }

    public void test3() {
        int max = hIndex.hIndex(new int[]{100});
        Assert.assertEquals(max, 1);
    }

    public void test4() {
        int index = hIndex.hIndex(new int[]{11, 15});
        Assert.assertEquals(index, 2);
    }

    public void test5() {
        int index = hIndex.hIndex(new int[]{3, 11, 15});
        Assert.assertEquals(index, 3);
    }


    public void test6() {
        int index = hIndex.hIndex(new int[]{0, 0, 4, 4});
        Assert.assertEquals(index, 2);
    }

    public void test7() {
        int index = hIndex.hIndex(new int[]{0, 0, 0, 4});
        Assert.assertEquals(index, 1);
    }

    public void test8() {
        int index = hIndex.hIndex(new int[]{0, 0, 0, 1});
        Assert.assertEquals(index, 1);
    }

    public void test9() {
        int index = hIndex.hIndex(new int[]{0, 0, 0, 0});
        Assert.assertEquals(index, 0);
    }

    public void test10() {
        int index = hIndex.hIndex(new int[]{1, 4, 7, 9});
        Assert.assertEquals(index, 3);
    }
}
