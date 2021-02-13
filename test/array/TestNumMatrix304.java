package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/13
 */
public class TestNumMatrix304 extends TestCase {

    public void test1() {
        NumMatrix304 numMatrix = new NumMatrix304(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        Assert.assertEquals(numMatrix.sumRegion(2, 1, 4, 3), 8);
        Assert.assertEquals(numMatrix.sumRegion(1, 1, 2, 2), 11);
        Assert.assertEquals(numMatrix.sumRegion(1, 2, 2, 4), 12);
    }

    public void test2() {
        NumMatrix304 numMatrix = new NumMatrix304(new int[][]{});
    }
}
