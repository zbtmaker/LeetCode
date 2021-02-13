package array;

import junit.framework.TestCase;
import org.junit.Assert;
import sun.jvm.hotspot.code.NMethod;

/**
 * @author Baitao Zou
 * date 2021/02/12
 */
public class TestNumArray307 extends TestCase {

    public void test1() {
        NumArray307 numArray = new NumArray307(new int[]{1, 3, 5});
        Assert.assertEquals(numArray.sumRange(0, 2), 9);
        numArray.update(1, 2);
        Assert.assertEquals(numArray.sumRange(0, 2), 8);
    }

    public void test2() {
        NumArray307 numArray = new NumArray307(new int[]{9, -8});
        numArray.update(0, 3);
        Assert.assertEquals(numArray.sumRange(1, 1), -8);
        Assert.assertEquals(numArray.sumRange(0, 1), -5);
        numArray.update(1, -3);
        Assert.assertEquals(numArray.sumRange(0, 1), 0);
    }

    public void test3() {
        NumArray307 numArray = new NumArray307(new int[]{0, 9, 5, 7, 3});
        Assert.assertEquals(numArray.sumRange(4, 4), 3);
        Assert.assertEquals(numArray.sumRange(2, 4), 15);
        Assert.assertEquals(numArray.sumRange(3, 3), 7);
        numArray.update(4, 5);
        numArray.update(1, 7);
        numArray.update(0, 8);
        Assert.assertEquals(numArray.sumRange(1, 2), 12);
        numArray.update(1, 9);
        Assert.assertEquals(numArray.sumRange(4, 4), 5);
        numArray.update(3, 4);

    }
}
