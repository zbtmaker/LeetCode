package array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/05
 */
public class HIndex274Test extends TestCase {

    private HIndex274 hIndex = new HIndex274();

    public void test1() {
        int index = hIndex.hIndex(new int[]{3, 0, 6, 1, 5});
        Assert.assertEquals(index, 3);
    }

    public void test2() {
        int index = hIndex.hIndex(new int[]{100});
        Assert.assertEquals(index, 1);
    }


    public void test3() {
        int index = hIndex.hIndex(new int[]{11, 15});
        Assert.assertEquals(index, 2);
    }
}
